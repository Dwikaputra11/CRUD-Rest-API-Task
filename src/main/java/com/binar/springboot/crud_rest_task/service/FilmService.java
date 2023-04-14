package com.binar.springboot.crud_rest_task.service;

import com.binar.springboot.crud_rest_task.models.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FilmService {

    Page<Film> findAll(Pageable pageable);

    Film findById(int id);

    Page<Film> findByLength(int length, Pageable pageable);

    Page<Film> findByReplacementCost(double replacementCost, Pageable pageable);

    Page<Film> findByRating(String rating, Pageable pageable);

    Page<Film> findByRentalDurationRange(int from, int to, Pageable pageable);

    Film save (Film film);

    Film update(Film updatedFilm);

    void delete(int id);

}
