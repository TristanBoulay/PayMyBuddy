package com.paymybuddy.Controllers;


import com.paymybuddy.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;



    @PutMapping("/settings")
    public ResponseEntity<User> modifyUserSettings(@ModelAttribute User user) {
        User savedUser = userService.modifyUserSettings(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser() {
        String message = "Logged in successfully!";
        return ResponseEntity.ok(message);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser() {
        String message = "Logged out successfully!";
        return ResponseEntity.ok(message);
    }
}

