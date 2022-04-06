package com.example.restuser.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ScheduleDto {
    public long id;
    public long filmId;
    public LocalDate startDateTime;
    public LocalDate endDateTime;
    public BigDecimal ticketPrice;

    public ScheduleDto() {

    }

    public ScheduleDto(long id, long filmId, LocalDate startDateTime, LocalDate endDateTime, BigDecimal ticketPrice) {
        this.id = id;
        this.filmId = filmId;
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

    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
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
