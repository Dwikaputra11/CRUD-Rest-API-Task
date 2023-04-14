package com.binar.springboot.crud_rest_task.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilterFilm {
    private String rating;
    private String rCost;
    private Integer from;
    private Integer to;
    private Double replacementCost;
}
