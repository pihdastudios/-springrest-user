package com.example.restuser.controller;

import com.example.restuser.dto.FilmDto;
import com.example.restuser.dto.ScheduleDto;
import com.example.restuser.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FilmController {
    @Autowired
    FilmService filmService;

    @PutMapping("/film")
    public void updateFilm(@RequestBody FilmDto filmDto) {
        filmService.saveFilm(filmDto);
    }

    @GetMapping("/films")
    public List<FilmDto> listFilms() {
        return filmService.findAll();
    }

    @PostMapping("/film")
    public void saveFilm(@RequestBody FilmDto filmDto) {
        filmDto.setId(0L);
        filmService.saveFilm(filmDto);
    }

    @DeleteMapping("/film/{id}")
    public void deleteUser(@PathVariable long id) {
        filmService.deleteFilm(id);
    }

    @GetMapping("/film/schedule/{id}")
    public Optional<List<ScheduleDto>> listScheduleById(@PathVariable long id) {
        return filmService.listScheduleById(id);
    }

    @GetMapping("/showing/films")
    public List<FilmDto> listShowing() {
        return filmService.listByShowing();
    }
}
