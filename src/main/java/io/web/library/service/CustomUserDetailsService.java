package io.web.library.service;

import io.web.library.detail.CustomUserDetails;
import io.web.library.model.User;
import io.web.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (email == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
