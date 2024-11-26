package com.bookmyevent.movie_booking.repository;

import com.bookmyevent.movie_booking.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, Integer>, JpaRepository<Movie, Integer> {
}
