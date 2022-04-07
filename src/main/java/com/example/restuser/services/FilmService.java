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
public interface FilmService {
    void saveFilm(FilmDto filmDto);

    List<Film> findAll();
    Optional<Film> findById(long id);
    void deleteFilm(long id);
}
