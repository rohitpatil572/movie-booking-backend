package com.bookmyevent.movie_booking.repository;

import com.bookmyevent.movie_booking.entity.City;
import com.bookmyevent.movie_booking.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
