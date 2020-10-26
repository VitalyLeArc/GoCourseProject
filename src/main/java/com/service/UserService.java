package com.service;

import com.domain.User;
import com.domain.parts.UserRole;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //вспомогательный метод
    private User getUserByName(String username){
        return userRepository.findUserByLoginname(username)
                .orElseThrow(()->new UsernameNotFoundException("Not found"+username));
    }

    public UserRole getUserRoleByName(String username){
        return getUserByName(username).getRole();
    }

    public Long getUserIdByName(String username){
        return getUserByName(username).getId();
    }

    public List<User> findAllUser(Principal principal){
            return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new UsernameNotFoundException("Does not exist ID "+id));
    }


    public void activateUser (String username){
            User user = getUserByName(username);
            user.setActiveStatus(true);
            userRepository.save(user);
    }
    public void createUser(User user){
        user.setActiveStatus(false); //чтоб наверняка
        userRepository.save(user);
    }

    //авторизация
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByLoginname(username).orElseThrow(()->new UsernameNotFoundException("Wrong login or password"));
    return new org.springframework.security.core.userdetails.User(user.getLoginname(),user.getPassword(),mapRolesToAuthorities(Collections.singletonList(user.getRole())));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<UserRole> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }
}
