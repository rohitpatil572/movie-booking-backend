package com.bookmyevent.movie_booking.controller;

import com.bookmyevent.movie_booking.dto.ApiResponse;
import com.bookmyevent.movie_booking.exception.BookingSystemException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookingSystemControllerAdvice {

    @ExceptionHandler(BookingSystemException.class)
    public ResponseEntity<ApiResponse<Void>> handleBookingSystemException(BookingSystemException ex) {
        return ResponseEntity.internalServerError().body(new ApiResponse<>(null, false, ex.getMessage(), ex.getErrorCode().name()));
    }
}
