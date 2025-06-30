package com.example.otp_service.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OtpServiceImpl implements OtpService{
    @Override
    public Integer getOtp(String userId) {
        return 2222;
    }
}
