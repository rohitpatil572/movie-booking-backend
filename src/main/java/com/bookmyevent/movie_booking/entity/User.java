package com.bookmyevent.movie_booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "app_users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer userId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile")
    private Long mobile;

    @Column(name = "age")
    private Integer age;

    @Column(name = "address_city")
    private Integer cityId;

}
