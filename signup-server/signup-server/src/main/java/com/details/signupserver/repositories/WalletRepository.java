package com.details.signupserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.details.signupserver.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, String> {
}