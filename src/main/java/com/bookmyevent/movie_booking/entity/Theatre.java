package com.bookmyevent.movie_booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theatres")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Theatre {

    @Id
    @GeneratedValue
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "city_id")
    Integer cityId;

}
