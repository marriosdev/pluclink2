package com.pluclink.api.modules.Auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pluclink.api.modules.Auth.security.UserAuthenticated;
import com.pluclink.api.modules.User.models.User;
import com.pluclink.api.modules.User.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    
        return new UserAuthenticated(user);
    }
}
