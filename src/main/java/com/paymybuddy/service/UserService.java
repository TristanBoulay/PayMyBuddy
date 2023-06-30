package com.paymybuddy.service;

import com.paymybuddy.model.User;
import com.paymybuddy.repository.UserRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    private User user;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User modifyUserSettings(@ModelAttribute User user) {
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        user.setRoleType(user.getRoleType());
        userRepository.save(user);
        return user;
    }

    public List<String> getFriendNameList(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("cet utilisateur n'existe pas"));
        List<String> friendList = new ArrayList<>();
        for (User friend : user.getFriends()) {
                friendList.add(friend.getName());
            }
        return friendList;
    }

    public User addFriend(Long senderId, Long receiverId) throws Exception{
        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        User receiver =userRepository.findById(receiverId)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());



        List<User> friends = sender.getFriends();

        friends.add(receiver);

        sender.setFriends(friends);

        userRepository.save(sender);

       return sender;
    }

}
