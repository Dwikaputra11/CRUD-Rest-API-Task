package com.binar.springboot.crud_rest_task.repos;

import com.binar.springboot.crud_rest_task.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    // find film by length > 60
    // find film by replacementCost > 10
    // find by Rating
    // find by rental duration between 2 and 5
    @Query(value = "SELECT f FROM Film f WHERE f.rentalDuration BETWEEN ?1 AND ?2")
    List<Film> findByRentalDurationRange(int from, int to);
}
