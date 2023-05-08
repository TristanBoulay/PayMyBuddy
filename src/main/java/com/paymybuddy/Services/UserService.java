package com.paymybuddy.Services;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User modifyUserSettings(User user) {
        return user;
    }
}
