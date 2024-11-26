package com.bookmyevent.movie_booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Booking {

    @Id
    @GeneratedValue
    @Column(name = "id")
    Integer id;

    @Column(name = "show_id")
    Integer showId;

    @Column(name = "booked_by")
    Integer userId;

    @Column(name = "seats_booked")
    Integer seatsBooked;

    @Column(name = "total_amount")
    Integer totalAmount;

    @Column(name = "payment_status")
    String paymentStatus;

    @Column(name = "status")
    String bookingStatus;
}
