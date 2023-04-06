package com.binar.springboot.crud_rest_task.controller;

import com.binar.springboot.crud_rest_task.models.Film;
import com.binar.springboot.crud_rest_task.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/film")
    public List<Film> findAll() {
        return filmService.findAll();
    }





}
