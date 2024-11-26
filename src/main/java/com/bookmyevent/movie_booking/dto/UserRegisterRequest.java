package com.bookmyevent.movie_booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {

    private String email;
    private String password;
    private String name;
    private Long mobile;
    private Integer age;
    private Integer city;
}
