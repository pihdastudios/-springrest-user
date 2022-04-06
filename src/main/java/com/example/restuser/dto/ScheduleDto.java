package com.example.restuser.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ScheduleDto {
    public long id;
    public long idFilm;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    public LocalDate startDateTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    public LocalDate endDateTime;
    public BigDecimal ticketPrice;

    public ScheduleDto() {

    }

    public ScheduleDto(long id, long idFilm, LocalDate startDateTime, LocalDate endDateTime, BigDecimal ticketPrice) {
        this.id = id;
        this.idFilm = idFilm;
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

    public long getFilm() {
        return idFilm;
    }

    public void setFilm(long idFilm) {
        this.idFilm = idFilm;
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
