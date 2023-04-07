package com.binar.springboot.crud_rest_task.service;

import com.binar.springboot.crud_rest_task.models.Film;

import java.util.List;
import java.util.Optional;

public interface FilmService {

    List<Film> findAll();

    Film findById(int id);

    List<Film> findByRentalDurationRange(int from, int to);

    Film save(Film film);

    Film update(Film film);

    void delete(int id);

}
