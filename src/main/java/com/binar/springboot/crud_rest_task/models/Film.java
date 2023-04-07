package com.binar.springboot.crud_rest_task.models;

import lombok.*;
import jakarta.persistence.*;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "film", schema = "public")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private int filmId;

    private String title;

    private String description;

    private String releaseYear;

    private Integer rentalDuration;

    private Double rentalRate;

    private Integer length;

    private Double replacementCost;

    private String rating;

    private String lastUpdate; // "yyyy-mm-dd HH:mm:ss"


}
