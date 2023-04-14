package com.binar.springboot.crud_rest_task.service;

import com.binar.springboot.crud_rest_task.models.Film;
import com.binar.springboot.crud_rest_task.repos.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<Film> findAll(Pageable pageable) {
        return filmRepository.findAll(pageable);
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
    public Page<Film> findByLength(int length, Pageable pageable) {
        return filmRepository.findByLength(length, pageable);
    }

    @Override
    public Page<Film> findByReplacementCost(double replacementCost, Pageable pageable) {
        return filmRepository.findByReplacementCost(replacementCost, pageable);
    }

    @Override
    public Page<Film> findByRating(String rating, Pageable pageable) {
        return filmRepository.findByRating(rating, pageable);
    }

    @Override
    public Page<Film> findByRentalDurationRange(int from, int to, Pageable pageable) {
        return filmRepository.findByRentalDurationRange(from, to, pageable);
    }

    @Override
    public Film save(Film film) {
        if (film.getTitle() != null && !film.getTitle().isEmpty()
                && film.getDescription() != null && !film.getDescription().isEmpty()
                && film.getReleaseYear()> 0 && film.getRentalDuration() > 0
                && film.getRentalRate() > 0 && film.getLength() > 0
                && film.getReplacementCost() > 0 && film.getRating() != null && !film.getRating().isEmpty()
                ) {
            return filmRepository.save(film);
        } else {
            throw new RuntimeException("Data film tidak lengkap");
        }
    }

    @Override
    public Film update(Film updatedFilm) {
        Optional<Film> result = filmRepository.findById(updatedFilm.getFilmId());
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
            return filmRepository.save(film);
        } else {
            throw new RuntimeException("Data film tidak ditemukan");
        }
    }

    @Override
    public void delete(int id) {
        Optional<Film> result = filmRepository.findById(id);
        if (result.isPresent()) {
            filmRepository.delete(result.get());
        } else {
            throw new RuntimeException("Data film tidak ditemukan");
        }
    }
}
