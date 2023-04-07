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
    public List<Film> findByRentalDurationRange(int from, int to) {
        return filmRepository.findByRentalDurationRange(from, to);
    }

    @Override
    public Film save(Film film) {
        return null;
    }

    @Override
    public Film update(Film film) {
        return null;
    }

    @Override
    public void delete(int id) {
        // TODO document why this method is empty
    }
}
