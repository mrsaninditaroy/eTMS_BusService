package com.details.signupserver.service;

import com.details.signupserver.entities.*;

public interface SignupService {
	
	Credential createCredential(Credential credential);
	
	Useridwalletlink createUseridwalletlink(Useridwalletlink useridwalletlink);
	
	Wallet createWallet(Wallet wallet);

}
