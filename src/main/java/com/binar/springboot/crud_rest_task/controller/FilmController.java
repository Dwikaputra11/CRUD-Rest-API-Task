package com.binar.springboot.crud_rest_task.controller;

import com.binar.springboot.crud_rest_task.models.Film;
import com.binar.springboot.crud_rest_task.request.RangeDuration;
import com.binar.springboot.crud_rest_task.service.FilmService;
import com.binar.springboot.crud_rest_task.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FilmController {

    private final FilmService filmService;
    private static final String SUCCESS_MSG = "Successfully retrieved data!";

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/film")
    public ResponseEntity<Object> findAll() {
        List<Film> filmList = filmService.findAll();
        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK,filmList);
    }

    @GetMapping("/film/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") int id) {
        Film film = filmService.findById(id);
        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK,film);
    }
    
    @GetMapping("/film/save")
    public ResponseEntity<Object> save(@RequestBody Film film){
        filmService.save(film);
        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK,film);
    }

    @GetMapping("/film/update")
    public ResponseEntity<Object> update(@RequestBody int id, Film film ){
        filmService.update(id, film);
        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK,film);

    @GetMapping("/film/search")
    public ResponseEntity<Object> findByRentalDurationRange(@RequestParam("from") int from, @RequestParam("to") int to){
        List<Film> filmList = filmService.findByRentalDurationRange(from, to);
        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK,filmList);
    }
}
