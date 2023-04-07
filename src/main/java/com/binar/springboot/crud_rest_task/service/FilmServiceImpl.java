package com.binar.springboot.crud_rest_task.service;

import com.binar.springboot.crud_rest_task.models.Film;
import com.binar.springboot.crud_rest_task.repos.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film findById(int id) {
        Optional<Film> result = filmRepository.findById(id);
        Film film;

        if (result.isPresent()) {
            film = result.get();
        }else
            throw new RuntimeException("Could not find film with id: " + id);

        return film;
    }

    @Override
    public List<Film> findByRc(double replacementCost) {
        return filmRepository.findByRc(replacementCost);
    }

//    @Override
//    public List<Film> findByRating(String rating) {
//        return filmRepository.findByRating(rating);
//    }

    @Override
    public List<Film> findByRentalDurationRange(int from, int to) {
        return filmRepository.findByRentalDurationRange(from, to);
    }

    @Override
    public Film save(Film film) {
        if (film.getTitle() != null && !film.getTitle().isEmpty()
                && film.getDescription() != null && !film.getDescription().isEmpty()
                && film.getReleaseYear() != null && !film.getReleaseYear().isEmpty()
                && film.getRentalDuration() > 0 && film.getRentalRate() > 0 && film.getLength() > 0
                && film.getReplacementCost() > 0 && film.getRating() != null && !film.getRating().isEmpty()
                && film.getLastUpdate() != null && !film.getLastUpdate().isEmpty()) {
            return filmRepository.save(film);
        } else {
            throw new RuntimeException("Data film tidak lengkap");
        }
    }

    @Override
    public Film update(int id, Film updatedFilm) {
        Optional<Film> result = filmRepository.findById(id);
        Film film;

        if (result.isPresent()) {
            film = result.get();
            film.setTitle(updatedFilm.getTitle());
            film.setDescription(updatedFilm.getDescription());
            film.setReleaseYear(updatedFilm.getReleaseYear());
            film.setRentalDuration(updatedFilm.getRentalDuration());
            film.setRentalRate(updatedFilm.getRentalRate());
            film.setLength(updatedFilm.getLength());
            film.setReplacementCost(updatedFilm.getReplacementCost());
            film.setRating(updatedFilm.getRating());
            film.setLastUpdate(updatedFilm.getLastUpdate());
            return filmRepository.save(film);
        } else {
            throw new RuntimeException("Data film tidak ditemukan");
        }
    }

    @Override
    public void delete(int id) {
        // TODO document why this method is empty
    }
}
