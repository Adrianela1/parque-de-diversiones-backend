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
    @Temporal (TemporalType.DATE)
    private LocalDate date;

    @Column(name = "hour", nullable = false, length = 45)
    private String hour;

    @Column(name = "id_game", nullable = false, length = 45)
    private String id_game;

    @Column(name = "id_buyer", nullable = false, length = 45)
    private String id_buyer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getId_game() {
        return id_game;
    }

    public void setId_game(String id_game) {
        this.id_game = id_game;
    }

    public String getId_buyer() {
        return id_buyer;
    }

    public void setId_buyer(String id_buyer) {
        this.id_buyer = id_buyer;
    }
}
