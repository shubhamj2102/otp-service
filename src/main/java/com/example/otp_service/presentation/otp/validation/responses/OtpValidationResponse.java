package com.example.otp_service.presentation.otp.validation.responses;

public class OtpValidationResponse {

    private Boolean isOtpValid;
    private String title;
    private String message;

    public Boolean getOtpValid() {
        return isOtpValid;
    }

    public void setOtpValid(Boolean otpValid) {
        isOtpValid = otpValid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
