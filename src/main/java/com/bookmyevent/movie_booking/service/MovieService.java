package com.bookmyevent.movie_booking.service;

import com.bookmyevent.movie_booking.entity.Movie;
import com.bookmyevent.movie_booking.exception.BookingSystemException;
import com.bookmyevent.movie_booking.exception.ErrorCode;
import com.bookmyevent.movie_booking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovie(Integer movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new BookingSystemException(ErrorCode.E003));
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
