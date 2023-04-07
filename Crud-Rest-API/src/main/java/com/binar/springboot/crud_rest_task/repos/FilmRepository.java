package com.binar.springboot.crud_rest_task.repos;

import com.binar.springboot.crud_rest_task.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    // find film by length > 60
    // find film by replacementCost > 10
    @Query(value = "SELECT f FROM Film f WHERE f.replacementCost < ?1")
    List<Film> findByRc(double replacementCost);
    // find by Rating
    @Query("SELECT f FROM Film f WHERE f.rating = ?1")
    List<Film> findByRating(String rating);
    // find by rental duration between 2 and 5
}
