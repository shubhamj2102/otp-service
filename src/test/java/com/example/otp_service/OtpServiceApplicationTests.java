package com.example.otp_service;

import com.example.otp_service.services.OtpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
@AutoConfigureMockMvc
class OtpServiceApplicationTests {

    @MockitoBean
    private OtpService otpService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        when(otpService.getOtp("123")).thenReturn(2222);
       mockMvc.perform(get("/otp/get").param("userId", "123")).andExpect(status().isOk()).andExpect(content().string("2222"));
       verify(otpService).getOtp("123");
    }

}
