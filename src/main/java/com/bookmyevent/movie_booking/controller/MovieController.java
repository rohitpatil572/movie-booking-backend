package com.bookmyevent.movie_booking.controller;

import com.bookmyevent.movie_booking.entity.Movie;
import com.bookmyevent.movie_booking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public Movie getAllMovies(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") Integer movieId) {
        return movieService.getMovie(movieId);
    }

}
