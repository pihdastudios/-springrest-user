package com.example.restuser.entity;

import javax.persistence.*;
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
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "film_id")
    private List<Schedule> schedules;

    public Film() {}

    public Film(long id, String name, boolean showing, List<Schedule> schedules) {
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

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", showing=" + showing +
                ", schedules=" + schedules +
                '}';
    }
}
