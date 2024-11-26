package com.bookmyevent.movie_booking.controller;


import com.bookmyevent.movie_booking.dto.BookingRequest;
import com.bookmyevent.movie_booking.dto.BookingResponse;
import com.bookmyevent.movie_booking.entity.Booking;
import com.bookmyevent.movie_booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/byUser/{email}")
    public List<BookingResponse> getBookingsByUser(@PathVariable("email") String email) {
        return bookingService.getBookingsByUser(email);
    }

    @PostMapping
    public Booking createNewBooking(@RequestBody BookingRequest booking) {
        return bookingService.saveBooking(booking);
    }

    @PostMapping("/pay/{bookingId}")
    public boolean doPaymentForBooking(@PathVariable("bookingId") Integer bookingId) {
        return bookingService.completePayment(bookingId);
    }

    @PostMapping("/cancel/{bookingId}")
    public boolean cancelBooking(@PathVariable("bookingId") Integer bookingId) {
        return bookingService.cancelBooking(bookingId);
    }
}
