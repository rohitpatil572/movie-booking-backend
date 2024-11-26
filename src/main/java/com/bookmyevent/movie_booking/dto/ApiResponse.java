package com.bookmyevent.movie_booking.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApiResponse<T> {
    private T data;
    private boolean success;
    private String errorMessage;
    private String errorCode;
}
