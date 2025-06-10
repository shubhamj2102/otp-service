package com.example.otp_service.presentation.otp.validation.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class OtpValidationRequest {
    @NotBlank(message = "OTP can not be blank")
    @Size(message = "Enter 4 digit OTP")
    private String otp;

    public String getOtp() {
        return otp;
    }
}
