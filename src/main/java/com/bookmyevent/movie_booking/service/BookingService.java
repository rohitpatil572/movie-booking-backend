package com.bookmyevent.movie_booking.service;

import com.bookmyevent.movie_booking.dto.BookingRequest;
import com.bookmyevent.movie_booking.dto.BookingResponse;
import com.bookmyevent.movie_booking.entity.Booking;
import com.bookmyevent.movie_booking.entity.Show;
import com.bookmyevent.movie_booking.entity.Theatre;
import com.bookmyevent.movie_booking.entity.User;
import com.bookmyevent.movie_booking.enums.BookingStatus;
import com.bookmyevent.movie_booking.enums.PaymentStatus;
import com.bookmyevent.movie_booking.exception.BookingSystemException;
import com.bookmyevent.movie_booking.exception.ErrorCode;
import com.bookmyevent.movie_booking.repository.BookingRepository;
import com.bookmyevent.movie_booking.repository.ShowRepository;
import com.bookmyevent.movie_booking.repository.TheatreRepository;
import com.bookmyevent.movie_booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;

    public List<BookingResponse> getBookingsByUser(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) throw new BookingSystemException(ErrorCode.E001);
        List<Booking> bookings = bookingRepository.findByUserId(user.getUserId());
        List<Integer> showIds = bookings.stream().map(Booking::getShowId).toList();
        Map<Integer, Show> showMap = showRepository.findAllById(showIds).stream().collect(Collectors.toMap(Show::getId, Function.identity()));
        return bookings.stream().map(booking -> BookingResponse.builder()
                .id(booking.getId())
                .bookingStatus(booking.getBookingStatus())
                .paymentStatus(booking.getPaymentStatus())
                .seatsBooked(booking.getSeatsBooked())
                .userId(booking.getUserId())
                .showId(booking.getShowId())
                .totalAmount(booking.getTotalAmount())
                .theatreId(showMap.get(booking.getShowId()).getTheatreId())
                .startDateTime(showMap.get(booking.getShowId()).getStartDateTime())
                .build()).toList();
    }

    public Booking saveBooking(BookingRequest request) {
        Show show = showRepository.findById(request.getShowId())
                .orElseThrow(() -> new BookingSystemException(ErrorCode.E004));
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) throw new BookingSystemException(ErrorCode.E001);
        if (show.getAvailableSeats() > request.getSeatsBooked()) {
            show.setAvailableSeats(show.getAvailableSeats() - request.getSeatsBooked());
            showRepository.save(show);
            Booking booking = new Booking();
            booking.setShowId(show.getId());
            booking.setUserId(user.getUserId());
            booking.setSeatsBooked(request.getSeatsBooked());
            booking.setPaymentStatus(PaymentStatus.PENDING.name());
            booking.setBookingStatus(BookingStatus.IN_PROGRESS.name());
            Integer totalAmount = booking.getSeatsBooked() * show.getPricePerPerson();
            booking.setTotalAmount(totalAmount);
            return bookingRepository.save(booking);
        } else {
            throw new BookingSystemException(ErrorCode.E006);
        }
    }

    public boolean completePayment(Integer bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingSystemException(ErrorCode.E005));
        booking.setPaymentStatus(PaymentStatus.COMPLETED.name());
        booking.setBookingStatus(BookingStatus.COMPLETED.name());
        bookingRepository.save(booking);
        return true;
    }

    public boolean cancelBooking(Integer bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingSystemException(ErrorCode.E005));
        booking.setPaymentStatus(PaymentStatus.REFUND_INITIATED.name());
        booking.setBookingStatus(BookingStatus.CANCELLED.name());
        bookingRepository.save(booking);
        return true;
    }
}
