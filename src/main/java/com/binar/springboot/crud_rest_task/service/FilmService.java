package com.binar.springboot.crud_rest_task.service;

import com.binar.springboot.crud_rest_task.models.Film;

import java.util.List;

public interface FilmService {

    List<Film> findAll();

    Film findById(int id);

    List<Film> findByReplacementCost(double replacementCost);

    List<Film> findByRating(String rating);

    List<Film> findByRentalDurationRange(int from, int to);

    Film save (Film film);

    Film update(Film updatedFilm);

    void delete(int id);

}
