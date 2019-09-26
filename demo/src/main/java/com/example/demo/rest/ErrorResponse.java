// ============================================================================
// File          : ErrorResponse
// Created       : 9/26/19
// Description   :
// Modifications :
//
// ============================================================================
// Copyright(c) 2019 Zoral, Ukraine
// ============================================================================
package com.example.demo.rest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorResponse {
    private final String error;
}
