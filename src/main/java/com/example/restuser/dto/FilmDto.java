package com.example.restuser.dto;

import com.example.restuser.entity.Film;
import com.example.restuser.entity.Schedule;

import java.util.ArrayList;
import java.util.List;

public class FilmDto {
    private long id;
    private String name;
    private boolean showing;
    private List<ScheduleDto> schedules = new ArrayList<>();

    public FilmDto() {
    }

    public FilmDto(Film film) {
        this.id = film.getId();
        this.name = film.getName();
        this.showing = film.isShowing();
        film.getSchedules().forEach(schedule -> this.schedules.add(new ScheduleDto(schedule.getId(), schedule.getStartDateTime(), schedule.getEndDateTime(), schedule.getTicketPrice())));
    }
    public static FilmDto withoutSchedules(Film film) {
        film.setSchedules(new ArrayList<>());
        return new FilmDto(film);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isShowing() {
        return showing;
    }

    public void setShowing(boolean showing) {
        this.showing = showing;
    }

    public List<ScheduleDto> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleDto> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "FilmDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", showing=" + showing +
                ", schedules=" + schedules +
                '}';
    }
}
