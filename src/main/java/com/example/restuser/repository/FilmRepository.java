package com.example.restuser.repository;

import com.example.restuser.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FilmRepository extends JpaRepository<Film, Long> {
    public List<Film> findFilmsByShowingIsTrue();
}
