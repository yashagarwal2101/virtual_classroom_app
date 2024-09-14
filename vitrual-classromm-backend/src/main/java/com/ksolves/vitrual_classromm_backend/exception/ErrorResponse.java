package com.ksolves.vitrual_classromm_backend.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private int status;
    private long timestamp;
}
