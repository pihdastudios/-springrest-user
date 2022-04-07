package com.example.restuser.services;

import com.example.restuser.dto.FilmDto;
import com.example.restuser.entity.Film;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FilmService {
    void saveFilm(FilmDto filmDto);

    List<Film> findAll();
    Optional<Film> findById(long id);
    void deleteFilm(long id);

    List<FilmDto> listScheduleById();
}
