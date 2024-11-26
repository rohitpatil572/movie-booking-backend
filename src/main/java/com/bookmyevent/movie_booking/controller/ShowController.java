package com.bookmyevent.movie_booking.controller;

import com.bookmyevent.movie_booking.entity.Show;
import com.bookmyevent.movie_booking.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping(path = "/byMovie/{movieId}")
    public List<Show> getShowsByMovie(@PathVariable("movieId") Integer movieId) {
        return showService.getShowsByMovie(movieId);
    }

    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }
}
