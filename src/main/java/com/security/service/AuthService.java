package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    public void authenticate (String login, String password){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login,password));
    }
}
