package com.binar.springboot.crud_rest_task.controller;

import com.binar.springboot.crud_rest_task.models.Film;
import com.binar.springboot.crud_rest_task.service.FilmService;
import com.binar.springboot.crud_rest_task.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FilmController {

    private final FilmService filmService;

    private static final Map<String, Object> mapParams = new HashMap<String, Object>();
    private static final String SUCCESS_MSG = "Successfully retrieved data!";

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }


    @GetMapping("/film")
    public ResponseEntity<Object> findAllOrByArgument(
            @RequestParam(value = "from", required = false) Integer from,
            @RequestParam(value = "to", required = false) Integer to,
            @RequestParam(value = "rCost", required = false) Double rCost,
            @RequestParam(value = "rating", required = false) String rating,
            @RequestParam(value = "length", required = false) Integer length
    ) {
        List<Film> filmList;
        if((from != null && to != null) && (from < to)){
            filmList = filmService.findByRentalDurationRange(from, to);
        }else if(rCost != null){
            filmList = filmService.findByReplacementCost(rCost);
        }else if(rating != null && !rating.isEmpty()){
            filmList = filmService.findByRating(rating);
        } else if (length!= null) {
            filmList = filmService.findByLength(length);
        } else{
            filmList = filmService.findAll();
        }

        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK,filmList);
    }

    @GetMapping("/film/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") int id) {
        Film film = filmService.findById(id);
        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK,film);
    }

    @PostMapping("/film")
    public ResponseEntity<Object> save(@RequestBody Film film){
        filmService.save(film);
        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK,film);
    }

    @PutMapping("/film")
    public ResponseEntity<Object> update(@RequestBody Film film ) {
        filmService.update(film);
        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK, film);
    }
    @DeleteMapping("/film/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id ) {
        filmService.delete(id);
        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK, id);
    }
}
