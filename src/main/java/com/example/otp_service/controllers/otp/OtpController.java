package com.example.otp_service.controllers.otp;

import com.example.otp_service.Exceptions.custom_exceptions.InValidOtpException;
import com.example.otp_service.presentation.otp.validation.requests.OtpValidationRequest;
import com.example.otp_service.presentation.otp.validation.responses.OtpValidationResponse;
import com.example.otp_service.services.OtpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("otp")
public class OtpController {

    private OtpService otpService;

    public OtpController(OtpService otpService) {
        this.otpService = otpService;
    }

    @GetMapping("get")
    public ResponseEntity<Integer> getOTP(@RequestParam String userId) {
       // int otp = 2222;
        //Business logic
        var otp=otpService.getOtp(userId);
        return ResponseEntity.status(HttpStatus.OK).body(otp);
    }

    @PostMapping("generate/{userId}")
    public ResponseEntity<String> generateOTP(@PathVariable String userId) {
        Random random = new Random();
        var randomNumber = random.nextInt(9000);
        var otp = String.format("%04d", randomNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(otp);
    }

    @PostMapping("validate/{userId}")
    public ResponseEntity<OtpValidationResponse> validateOtp(@PathVariable String userId, @RequestBody OtpValidationRequest otpValidationRequest){
        var requestOtp=otpValidationRequest.getOtp();
        //fetch OTP from DB
        var actualOtp="2222";
        var otpValidationResponse=new OtpValidationResponse();
        if(requestOtp.equals(actualOtp)){
            otpValidationResponse.setTitle("Valid OTP");
            otpValidationResponse.setMessage("Otp is Valid");
            otpValidationResponse.setOtpValid(true);
            return ResponseEntity.status(HttpStatus.OK).body(otpValidationResponse);
        }
        throw new InValidOtpException(HttpStatus.BAD_REQUEST,"OTP is not valid");
    }
}
