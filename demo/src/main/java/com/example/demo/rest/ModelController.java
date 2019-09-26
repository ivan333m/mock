// ============================================================================
// File          : ModelController
// Created       : 9/26/19
// Description   :
// Modifications :
//
// ============================================================================
// Copyright(c) 2019 Zoral, Ukraine
// ============================================================================
package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ModelController {

    @GetMapping("/models")
    public ResponseEntity<String> findAllModels() {
        //Some Logic
        dataExistenceCheck("response");
        return new ResponseEntity<>("response", HttpStatus.OK);
    }

    private <T> void dataExistenceCheck(T target) {
//        if (target == null || (target instanceof Collection && ((Collection<?>) target).isEmpty())) {
            throw new NoDataFoundException();
//        }
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ErrorResponse> noDataFoundExceptionHandler(NoDataFoundException exception) {
        System.out.println("No data found exception [{}]." + exception.getMessage());
        return new ResponseEntity<>(new ErrorResponse("not found"), HttpStatus.NOT_FOUND);
    }
}
