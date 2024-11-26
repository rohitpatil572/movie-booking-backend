package com.bookmyevent.movie_booking.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    E000("Something wrong happened"),
    E001("User not found"),
    E002("User already exists"),
    E003("Movie not found"),
    E004("Show not found"),
    E005("Booking not found"),
    E006("Booking not allowed");

    private final String message;
    ErrorCode(String message) {
        this.message = message;
    }
}
