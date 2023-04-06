package com.binar.springboot.crud_rest_task.repos;

import com.binar.springboot.crud_rest_task.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {


}
