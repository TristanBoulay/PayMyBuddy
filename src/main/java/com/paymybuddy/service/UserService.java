package com.paymybuddy.service;

import com.paymybuddy.model.SecurityUser;
import com.paymybuddy.model.User;
import com.paymybuddy.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class UserService implements UserDetailsService
{
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User modifyUserSettings(@ModelAttribute User user)
    {
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        userRepository.save(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return userRepository.findByName(username)
                .map(SecurityUser::new )
                .orElseThrow(()-> new UsernameNotFoundException("User name not found :"+ username));
    }
}
