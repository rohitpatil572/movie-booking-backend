package com.bookmyevent.movie_booking.exception;

import lombok.Getter;

@Getter
public class BookingSystemException extends RuntimeException{

    private ErrorCode errorCode;

    public BookingSystemException() {
        super();
    }
    public BookingSystemException(ErrorCode error) {
        super(error.getMessage());
        this.errorCode = error;
    }

    public BookingSystemException(ErrorCode error, String message) {
        super(message);
        this.errorCode = error;
    }
}
