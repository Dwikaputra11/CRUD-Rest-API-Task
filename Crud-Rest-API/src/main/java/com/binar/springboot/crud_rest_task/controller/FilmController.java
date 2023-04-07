package com.binar.springboot.crud_rest_task.controller;

import com.binar.springboot.crud_rest_task.models.Film;
import com.binar.springboot.crud_rest_task.repos.FilmRepository;
import com.binar.springboot.crud_rest_task.service.FilmService;
import com.binar.springboot.crud_rest_task.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FilmController {

    private final FilmService filmService;
    private static final String SUCCESS_MSG = "Successfully retrieved data!";
    private static final String ERROR_MSG = "Failed to retrieve data!";

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/film")
    public List<Film> findAll() {
        return filmService.findAll();
    }

    @GetMapping("/film/findById")
    public Optional<Film> findById(@RequestParam int film_id) {
        return filmRepository.findById(film_id);
    }

    @GetMapping("/film/findByRc")
    public ResponseEntity<Object> findByRc(@RequestParam("replacementCost") double replacement_cost){
        List<Film> filmList = filmService.findByRc(replacement_cost);
//        return (ResponseEntity<Objects>) filmList;
        if(filmList.isEmpty()) {
            return ResponseHandler.generateResponse(ERROR_MSG, HttpStatus.NOT_FOUND, null);
        }
        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK,filmList);
    }

    @GetMapping("/film/findByRating")
    public ResponseEntity<Object> findByRating(@RequestParam("rating") String rating) {
        List<Film> filmList = filmService.findByRating(rating);
        if(filmList.isEmpty()) {
            return ResponseHandler.generateResponse(ERROR_MSG, HttpStatus.NOT_FOUND, null);
        }
        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK, filmList);
    }

//    @GetMapping("/findByRc/{replacement_cost}")
//    public List<Film> findByRc(@PathVariable double replacementCost){
//        List<Film> findRc = filmService.findByRc(replacementCost);
//        return findRc;
//    }

//    @GetMapping("/film/findByRating")
//    public ResponseEntity<Object> fingByRating(@RequestParam("rating") String rating){
//        List<Film> filmList = filmService.findByRating(rating);
//        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK, filmList);
////        return filmRepository.findByRating(rating);
//    }





}
