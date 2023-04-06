package com.binar.springboot.crud_rest_task.repos;

import com.binar.springboot.crud_rest_task.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
    // find film by length > 60
    // find film by replacementCost > 10
    // find by Rating
    // find by rental duration between 2 and 5
}
