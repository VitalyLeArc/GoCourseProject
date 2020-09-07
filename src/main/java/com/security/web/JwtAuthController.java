package com.security.web;

import com.security.config.JwtTokenUtil;
import com.security.vm.JwtRequest;
import com.security.service.JwtAuthService;
import com.security.service.JwtUserDetailsService;
import com.security.vm.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class JwtAuthController {

    @Autowired
    private JwtAuthService authService;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public ResponseEntity<?> createAuthToken (@RequestBody JwtRequest jwtRequest){
        authService.authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        final UserDetails userDetails=userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        final String token=jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }


}
