package com.example.otp_service.Exceptions.custom_exceptions;

import org.springframework.http.HttpStatus;

public class InValidOtpException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public InValidOtpException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public InValidOtpException(String message) {
        this.message = message;
    }




    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
