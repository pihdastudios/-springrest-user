package com.example.restuser.entity;

import com.example.restuser.dto.FilmDto;
import lombok.var;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "showing")
    private boolean showing;

    @Column(name = "schedules")
    @OneToMany(mappedBy = "film", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Schedule> schedules;

    public Film() {
    }

    public Film(long id, String name, boolean showing) {
        this.id = id;
        this.name = name;
        this.showing = showing;
    }

    public Film(FilmDto filmDto) {
        this(filmDto.getId(), filmDto.getName(), filmDto.isShowing());
        List<Schedule> schedules = new ArrayList<>();
        filmDto.getSchedules().forEach(scheduleDto -> {
            var schedule = new Schedule(scheduleDto.getId(), this, scheduleDto.getStartDateTime(), scheduleDto.getEndDateTime(), scheduleDto.getTicketPrice());
            schedules.add(schedule);
        });
        this.setSchedules(schedules);
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

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                '}';
    }
}
