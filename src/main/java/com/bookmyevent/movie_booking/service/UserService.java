package com.bookmyevent.movie_booking.service;

import com.bookmyevent.movie_booking.dto.UserLoginRequest;
import com.bookmyevent.movie_booking.dto.UserLoginResponse;
import com.bookmyevent.movie_booking.dto.UserRegisterRequest;
import com.bookmyevent.movie_booking.dto.UserRegisterResponse;
import com.bookmyevent.movie_booking.entity.User;
import com.bookmyevent.movie_booking.exception.BookingSystemException;
import com.bookmyevent.movie_booking.exception.ErrorCode;
import com.bookmyevent.movie_booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public UserRegisterResponse registerUser(UserRegisterRequest user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            User newUser = new User();
            newUser.setName(user.getName());
            newUser.setEmail(user.getEmail());
            newUser.setCityId(user.getCity());
            newUser.setMobile(user.getMobile());
            newUser.setEmail(user.getEmail());
            newUser.setAge(user.getAge());
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
            User savedUser = userRepository.save(newUser);
            return new UserRegisterResponse(savedUser.getEmail(), jwtService.generateToken(user.getEmail()));
        }
        throw new BookingSystemException(ErrorCode.E002);
    }

    public UserLoginResponse verifyUser(UserLoginRequest user) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            if (authentication.isAuthenticated()) {
                return new UserLoginResponse(user.getEmail(), jwtService.generateToken(user.getEmail()));
            }
        } catch (AuthenticationException ex) {
            throw new BookingSystemException(ErrorCode.E000, ex.getMessage());
        } catch (Exception ex) {
            throw new BookingSystemException(ErrorCode.E000);
        }
        throw new BookingSystemException(ErrorCode.E001);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
