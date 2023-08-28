package com.details.signupserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.details.signupserver.repositories.CredentialRepository;

import com.details.signupserver.entities.Credential;
import com.details.signupserver.entities.Wallet;
import com.details.signupserver.entities.Useridwalletlink;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/signup")
public class SignupController
{
	Logger logger = LoggerFactory.getLogger(SignupController.class);
	
    @Autowired
    CredentialRepository credentialRepository;

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestParam("userid") String userid,@RequestParam("username") String username, @RequestParam("password") String password )
    {
        Credential credential = new Credential();
        credential.setId(userid);
        credential.setUsename(username);
        credential.setPassword(password);
        credentialRepository.save(credential);

        String walletid = String.valueOf((int)(Math.random()*10000));
        Wallet wallet = new Wallet();
        wallet.setId(walletid);
        wallet.setBalance(String.valueOf(0));

        Useridwalletlink usernamewalletlink = new Useridwalletlink();
        usernamewalletlink.setUserid(userid);
        usernamewalletlink.setUsername(username);
        usernamewalletlink.setWalletid(walletid);

        return new ResponseEntity<>("New User Successfully Signed Up", HttpStatus.OK);


    }

}
