package com.paymybuddy.controller;


import com.paymybuddy.model.User;
import com.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;



    @PutMapping("/settings")
    public ResponseEntity<User> modifyUserSettings(@ModelAttribute User user) {
        User savedUser = userService.modifyUserSettings(user);
        return ResponseEntity.ok(savedUser);
    }







    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser() {
        String message = "Logged out successfully!";
        return ResponseEntity.ok(message);
    }

    @GetMapping ("/{id}/friends")
    public ResponseEntity<List> getFriendsList(@PathVariable Long id) {
            List<String> friends = userService.getFriendNameList(id);
            return ResponseEntity.ok(friends);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addFriend(@RequestParam("userId") Long userId, @RequestParam("friendId") Long friendId) throws Exception {
        User user = userService.addFriend(userId, friendId);
        return ResponseEntity.ok(user);
    }
}

