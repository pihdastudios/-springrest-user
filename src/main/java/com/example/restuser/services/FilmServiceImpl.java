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
        film.setSchedules(schedules);
        filmRepository.save(film);
    }

    public List<FilmDto> findAll() {
        var filmDtos = new ArrayList<FilmDto>();
        filmRepository.findAll().forEach(film -> filmDtos.add(new FilmDto(film)));
        return filmDtos;
    }
    public Optional<FilmDto> findById(long id) {
        return filmRepository.findById(id).map(FilmDto::new);
    }
    public void deleteFilm(long id) {
        if (filmRepository.findById(id).isPresent()) {
            filmRepository.deleteById(id);
        }
    }

    @Override
    public List<FilmDto> listScheduleById() {
        var filmDtos = new ArrayList<FilmDto>();
        filmRepository.findFilmsByShowingIsTrue().forEach(film -> {
            filmDtos.add(new FilmDto(film));
        });
        return filmDtos;
    }

}
