package com.example.restuser.services;

import com.example.restuser.dto.FilmDto;
import com.example.restuser.dto.ScheduleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FilmService {
    void saveFilm(FilmDto filmDto);

    List<FilmDto> findAll();

    Optional<FilmDto> findById(long id);

    void deleteFilm(long id);

    Optional<List<ScheduleDto>> listScheduleById(long id);

    List<FilmDto> listByShowing();
}
