package com.binar.springboot.crud_rest_task.service;

import com.binar.springboot.crud_rest_task.models.Film;

import java.util.List;

public interface FilmService {

    List<Film> findAll();

    Film save(Film film);

    Film update(Film film);

    void delete(int id);

}
