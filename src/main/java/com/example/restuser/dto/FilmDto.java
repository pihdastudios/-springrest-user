package com.example.restuser.dto;

import java.util.List;

public class FilmDto {
    private long id;
    private String name;
    private boolean showing;
    private List<ScheduleDto> schedules;

    public FilmDto() {}
    public FilmDto(long id, String name, boolean showing, List<ScheduleDto> schedules) {
        this.id = id;
        this.name = name;
        this.showing = showing;
        this.schedules = schedules;
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
}