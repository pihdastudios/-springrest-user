package com.example.restuser.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id")
    public Film film;

    @Column(name = "start_datetime")
    public LocalDateTime startDateTime;
    @Column(name = "end_datetime")
    public LocalDateTime endDateTime;

    @Column(name = "ticket_price")
    public BigDecimal ticketPrice;

    public Schedule() {
    }

    public Schedule(long id, Film film, LocalDateTime startDateTime, LocalDateTime endDateTime, BigDecimal ticketPrice) {
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

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}

