package com.bookmyevent.movie_booking.controller;

import com.bookmyevent.movie_booking.entity.City;
import com.bookmyevent.movie_booking.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    private List<City> getAllCities() {
        return cityRepository.findAll();
    }

}
