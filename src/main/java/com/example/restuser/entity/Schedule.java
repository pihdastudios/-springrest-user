package com.example.restuser.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;

    @ManyToOne
    @JoinColumn(name = "film_id")
    public Film film;

    @Column(name = "start_datetime")
    public LocalDate startDateTime;
    @Column(name = "end_datetime")
    public LocalDate endDateTime;

    @Column(name = "ticket_price")
    public BigDecimal ticketPrice;

    public Schedule() {}

    public Schedule(long id, Film film, LocalDate startDateTime, LocalDate endDateTime, BigDecimal ticketPrice) {
        this.id = id;
        this.film = film;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.ticketPrice = ticketPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public LocalDate getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDate startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDate getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDate endDateTime) {
        this.endDateTime = endDateTime;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}

