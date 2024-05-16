package com.msvc.tickets.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table( name = "tickets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "hour", nullable = false, length = 45)
    private String hour;

    @Column(name = "id_game", nullable = false, length = 45)
    private String id_game;

    @Column(name = "id_buyer", nullable = false, length = 45)
    private String id_buyer;
}
