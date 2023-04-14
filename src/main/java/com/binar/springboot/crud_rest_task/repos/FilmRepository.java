package com.binar.springboot.crud_rest_task.repos;

import com.binar.springboot.crud_rest_task.models.Film;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    // find film by length > 60
    @Query("SELECT f FROM Film f WHERE f.length >?1")
    Page<Film> findByLength(int length, Pageable pageable);
    // find film by replacementCost > 10
    @Query("SELECT f FROM Film f WHERE f.replacementCost > ?1")
    Page<Film> findByReplacementCost(double replacementCost, Pageable pageable);
    // find by Rating
    @Query(value = "SELECT f FROM Film f WHERE f.rating LIKE %?1")
    Page<Film> findByRating(String rating,Pageable pageable);
    // find by rental duration between 2 and 5
    @Query(value = "SELECT f FROM Film f WHERE f.rentalDuration BETWEEN ?1 AND ?2")
    Page<Film> findByRentalDurationRange(int from, int to,Pageable pageable);
}
