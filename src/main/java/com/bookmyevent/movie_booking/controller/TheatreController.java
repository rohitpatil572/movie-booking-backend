package com.bookmyevent.movie_booking.controller;

import com.bookmyevent.movie_booking.entity.Theatre;
import com.bookmyevent.movie_booking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    @Autowired
    private TheatreRepository theatreRepository;

    @GetMapping
    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }
}
