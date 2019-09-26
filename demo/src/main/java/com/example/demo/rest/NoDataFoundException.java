// ============================================================================
// File          : NoDataFoundException
// Created       : 9/26/19
// Description   :
// Modifications :
//
// ============================================================================
// Copyright(c) 2019 Zoral, Ukraine
// ============================================================================
package com.example.demo.rest;

public class NoDataFoundException extends RuntimeException {

    private static final long serialVersionUID = 140836818081224458L;

    public NoDataFoundException() {
        super();
    }

    public NoDataFoundException(String message) {
        super(message);
    }

}
