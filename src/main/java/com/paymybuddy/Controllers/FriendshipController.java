package com.paymybuddy.Controllers;

import com.paymybuddy.Models.Friendship;
import com.paymybuddy.Services.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friendship")
public class FriendshipController {

    @Autowired
    private FriendshipService friendshipService;

    @PostMapping("/add")
    public ResponseEntity<Friendship> addFriend(@RequestParam("userId") Long userId, @RequestParam("friendId") Long friendId) {
        Friendship friendship = friendshipService.addFriend(userId, friendId);
        return ResponseEntity.ok(friendship);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeFriend(@RequestParam("userId") Long userId, @RequestParam("friendId") Long friendId) {
        friendshipService.removeFriend(userId, friendId);
        return ResponseEntity.noContent().build();
    }
}
