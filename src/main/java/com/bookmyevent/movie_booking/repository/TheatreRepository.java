package com.bookmyevent.movie_booking.repository;

import com.bookmyevent.movie_booking.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    List<Theatre> findByCityId(Integer cityId);
}
