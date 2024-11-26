package com.bookmyevent.movie_booking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "shows")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Show {

    @Id
    @GeneratedValue
    @Column(name = "id")
    Integer id;

    @Column(name = "movie_id")
    Integer movieId;

    @Column(name = "theatre_id")
    Integer theatreId;

    @Column(name = "start_time")
    LocalDateTime startDateTime;

    @Column(name = "available_seats")
    Integer availableSeats;

    @Column(name = "price_per_person")
    Integer pricePerPerson;
}
