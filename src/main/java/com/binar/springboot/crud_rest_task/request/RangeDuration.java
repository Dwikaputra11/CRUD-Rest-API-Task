package com.binar.springboot.crud_rest_task.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class RangeDuration {
    private int from;
    private int to;
}
