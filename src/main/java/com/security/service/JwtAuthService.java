package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    public void authenticate (String username, String password){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
    }

}
