package com.bookmyevent.movie_booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Movie {

    @Id
    @GeneratedValue
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "genre")
    String genre;

    @Column(name = "poster", length = Integer.MAX_VALUE)
    byte[] poster;

    @Column(name = "duration")
    Long duration;

}
