package com.example.otp_service.Exceptions.exception_handlers;

import com.example.otp_service.Exceptions.custom_exceptions.InValidOtpException;
import com.example.otp_service.controllers.otp.OtpController;
import com.example.otp_service.presentation.global.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice(assignableTypes = OtpController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(InValidOtpException.class)
    public ResponseEntity<ErrorResponse> handleException(InValidOtpException e){
        var errorResponse=new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
