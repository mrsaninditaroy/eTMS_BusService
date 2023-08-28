package com.details.signupserver.service.impl;

import org.springframework.stereotype.Service;
import com.details.signupserver.entities.Credential;
import com.details.signupserver.entities.Useridwalletlink;
import com.details.signupserver.entities.Wallet;
import com.details.signupserver.service.SignupService;
import com.details.signupserver.repositories.CredentialRepository;
import com.details.signupserver.repositories.UseridwalletlinkRepository;
import  com.details.signupserver.repositories.WalletRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SignupServiceImpl implements SignupService{
	
	WalletRepository walletRepository;
	
	CredentialRepository credentialRepository;
	
	UseridwalletlinkRepository useridwalletlinkRepository;
	

	@Override
	public Credential createCredential(Credential credential) {
		// TODO Auto-generated method stub
		return credentialRepository.save(credential);
	}

	@Override
	public Useridwalletlink createUseridwalletlink(Useridwalletlink useridwalletlink) {
		// TODO Auto-generated method stub
		return useridwalletlinkRepository.save(useridwalletlink);
	}

	@Override
	public Wallet createWallet(Wallet wallet) {
		// TODO Auto-generated method stub
		return walletRepository.save(wallet);
	}

}
