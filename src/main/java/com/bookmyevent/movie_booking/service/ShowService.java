package com.bookmyevent.movie_booking.service;

import com.bookmyevent.movie_booking.entity.Show;
import com.bookmyevent.movie_booking.entity.Theatre;
import com.bookmyevent.movie_booking.repository.ShowRepository;
import com.bookmyevent.movie_booking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    public List<Show> getShowsByMovie(Integer movieId) {
        return showRepository.findByMovieId(movieId);
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }
}
