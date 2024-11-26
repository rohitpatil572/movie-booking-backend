package com.bookmyevent.movie_booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class City {

    @Id
    @GeneratedValue
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String name;
}
