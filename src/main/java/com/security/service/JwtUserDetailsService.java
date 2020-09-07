package com.security.service;

import com.domain.User;
import com.repository.UserRepository;
import com.security.config.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findUserByLoginname(username)
                .orElseThrow(()-> new EntityNotFoundException("Not found login = "+ username));
        UserDetailsImpl userDetails= new UserDetailsImpl(user);

        return userDetails;
    }

}
