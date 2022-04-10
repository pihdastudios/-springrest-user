package com.example.restuser.services;

import com.example.restuser.dto.FilmDto;
import com.example.restuser.dto.ScheduleDto;
import com.example.restuser.entity.Film;
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
        filmRepository.save(new Film(filmDto));
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

    public Optional<List<ScheduleDto>> listScheduleById(long id) {
        Optional<List<ScheduleDto>> ret = Optional.of(new ArrayList<>());
        var film = filmRepository.findById(id);
        film.map(FilmDto::new).ifPresent(filmDto -> filmDto.getSchedules().forEach(scheduleDto -> ret.get().add(scheduleDto)));
        return ret;
    }

    public List<FilmDto> listByShowing() {
        var filmDtos = new ArrayList<FilmDto>();
        filmRepository.findFilmsByShowingIsTrue().forEach(film -> {
            film.setSchedules(new ArrayList<>());
            filmDtos.add(new FilmDto(film));
        });
        return filmDtos;
    }
}
