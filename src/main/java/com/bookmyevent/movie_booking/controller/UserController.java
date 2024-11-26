package com.bookmyevent.movie_booking.controller;

import com.bookmyevent.movie_booking.dto.UserLoginRequest;
import com.bookmyevent.movie_booking.dto.UserLoginResponse;
import com.bookmyevent.movie_booking.dto.UserRegisterRequest;
import com.bookmyevent.movie_booking.dto.UserRegisterResponse;
import com.bookmyevent.movie_booking.entity.User;
import com.bookmyevent.movie_booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> loginUser(@RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(userService.verifyUser(request));
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> registerUser(@RequestBody UserRegisterRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }
}
