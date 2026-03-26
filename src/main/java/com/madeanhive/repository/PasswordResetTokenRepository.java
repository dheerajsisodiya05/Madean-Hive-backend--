package com.madeanhive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madeanhive.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
	PasswordResetToken findByToken(String token);
}
