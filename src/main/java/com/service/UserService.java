package com.service;

import com.domain.User;
import com.domain.enums.UserRole;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
//не проверял
    public void activateUser (String login){
        User user = userRepository.findUserByLoginname(login).orElse(null);
        user.setActiveStatus(true);
        userRepository.save(user);
    }
    public void createUser(User user){
        userRepository.save(user);
    }
}
