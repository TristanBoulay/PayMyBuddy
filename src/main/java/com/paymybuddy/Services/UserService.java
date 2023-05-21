package com.paymybuddy.Services;

import com.paymybuddy.Models.Friendship;
import com.paymybuddy.Models.User;
import com.paymybuddy.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    private User user;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User modifyUserSettings(@ModelAttribute User user) {
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        userRepository.save(user);
        return user;
    }

    public List<String> getFriendNameList(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("cet utilisateur n'existe pas"));

        List<String> friendList = new ArrayList<>();
        for (Friendship friendship : user.getFriends()) {
            Long friendId = friendship.getSenderUser();
            if (friendId != user.getId()) {
                User friend = userRepository.findById(friendId)
                        .orElseThrow(() -> new EntityNotFoundException("Friend not found"));
                friendList.add(friend.getName());
            }

        }
        return friendList;
    }

}
