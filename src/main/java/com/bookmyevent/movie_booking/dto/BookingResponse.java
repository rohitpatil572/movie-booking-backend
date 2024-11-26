package com.bookmyevent.movie_booking.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingResponse {

    Integer id;
    Integer showId;
    Integer theatreId;
    Integer userId;
    Integer seatsBooked;
    Integer totalAmount;
    String paymentStatus;
    String bookingStatus;
    LocalDateTime startDateTime;
}
