package com.binar.springboot.crud_rest_task.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseHandler {

    private ResponseHandler(){}
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.value());

        if(responseObj instanceof List<?> list){
            map.put("totalRecords", list.size());
            map.put("data", responseObj);
        }else {
            var list = new ArrayList<>();
            list.add(responseObj);
            map.put("data", list);
            map.put("totalRecords", list.size());
        }

        return new ResponseEntity<>(map, status);
    }
}
