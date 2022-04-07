package com.example.restuser.controller;

import com.example.restuser.dto.FilmDto;
import com.example.restuser.entity.Film;
import com.example.restuser.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Film> listFilms() {
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

//    @GetMapping("(/film/schedule/{id}")
//    public void listSchedule(@PathVariable long id) {
//        filmService.listScheduleById(long id);
//    }

    @GetMapping("/showing/films")
    public List<FilmDto> listShowing() {
        return filmService.listScheduleById();
    }
}
