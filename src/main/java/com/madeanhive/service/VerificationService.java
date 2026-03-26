package com.madeanhive.service;

import com.madeanhive.model.VerificationCode;

public interface VerificationService {

    VerificationCode createVerificationCode(String otp, String email);
}
