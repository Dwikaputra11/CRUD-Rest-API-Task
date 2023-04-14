package com.binar.springboot.crud_rest_task.controller;

import com.binar.springboot.crud_rest_task.models.Film;
import com.binar.springboot.crud_rest_task.service.FilmService;
import com.binar.springboot.crud_rest_task.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FilmController {

    private final FilmService filmService;
    private static final String SUCCESS_RETRIEVE_MSG = "Successfully retrieved data!";
    private static final String SUCCESS_EDIT_MSG = "Successfully edit data!";

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
            @RequestParam(value = "length", required = false) Integer length,
            @RequestParam(defaultValue ="0") int page,
            @RequestParam(defaultValue ="10") int size
    ) {
        Page<Film> filmList;
        Pageable pageable = PageRequest.of(page, size);

        if((from != null && to != null) && (from < to)){
            filmList = filmService.findByRentalDurationRange(from, to, pageable);
        }else if(rCost != null){
            filmList = filmService.findByReplacementCost(rCost, pageable);
        }else if(rating != null && !rating.isEmpty()){
            filmList = filmService.findByRating(rating, pageable);
        } else if (length != null) {
            filmList = filmService.findByLength(length, pageable);
        } else{
            filmList = filmService.findAll(pageable);
        }

        return ResponseHandler.generatePagingResponse(SUCCESS_RETRIEVE_MSG, HttpStatus.OK,filmList);
    }

    @GetMapping("/film/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") int id) {
        Film film = filmService.findById(id);
        return ResponseHandler.generateResponse(SUCCESS_RETRIEVE_MSG, HttpStatus.OK,film);
    }

    @PostMapping("/film")
    public ResponseEntity<Object> save(@RequestBody Film film){
        filmService.save(film);
        return ResponseHandler.generateResponse(SUCCESS_EDIT_MSG, HttpStatus.OK,film);
    }

    @PutMapping("/film")
    public ResponseEntity<Object> update(@RequestBody Film film ) {
        filmService.update(film);
        return ResponseHandler.generateResponse(SUCCESS_EDIT_MSG, HttpStatus.OK, film);
    }
    @DeleteMapping("/film/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id ) {
        filmService.delete(id);
        return ResponseHandler.generateResponse(SUCCESS_EDIT_MSG, HttpStatus.OK, id);
    }
}
