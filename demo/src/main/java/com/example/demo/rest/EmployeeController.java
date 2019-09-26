package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @ResponseStatus(HttpStatus.CREATED)
    public String getEmploee(@RequestBody String employee) {
        System.out.println(employee);
        return employee;
    }

}
