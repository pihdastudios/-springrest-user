package com.example.restuser.services;

import com.example.restuser.dto.FilmDto;
import com.example.restuser.entity.Film;
import com.example.restuser.entity.Schedule;
import com.example.restuser.repository.FilmRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    FilmRepository filmRepository;

    public void saveFilm(FilmDto filmDto) {
        var film = new Film(filmDto.getId(), filmDto.getName(), filmDto.isShowing(), null);
        List<Schedule> schedules = new ArrayList<>();
        filmDto.getSchedules().forEach(scheduleDto -> {
            var schedule = new Schedule(scheduleDto.getId(), film, scheduleDto.getStartDateTime(), scheduleDto.getEndDateTime(), scheduleDto.getTicketPrice());
            schedules.add(schedule);
        });
        System.out.println(schedules);
        film.setSchedules(schedules);
        filmRepository.save(film);
    }

    public List<Film> findAll() {
        return filmRepository.findAll();
    }
    public Optional<Film> findById(long id) {
        return filmRepository.findById(id);
    }
    public void deleteFilm(long id) {
        if (filmRepository.findById(id).isPresent()) {
            filmRepository.deleteById(id);
        }
    }
}
