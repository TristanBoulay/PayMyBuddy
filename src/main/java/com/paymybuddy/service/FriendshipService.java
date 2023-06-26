package com.paymybuddy.service;

import com.paymybuddy.repository.FriendshipRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FriendshipService
{
    private final FriendshipRepository friendshipRepository;

    public FriendshipService(FriendshipRepository friendshipRepository)
    {
        this.friendshipRepository = friendshipRepository;
    }

    // TODO : corriger la partie friendship
    public List<String> getFriendNameList(Long userId)
    {
        /*
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("cet utilisateur n'existe pas"));
        List<String> friendList = new ArrayList<>();
        for (User friend : user.getFriends()) {
                friendList.add(friend.getName());
            }
        return friendList;
        */
        return null;
    }

    /*
    public User addFriend(Long senderId, Long receiverId) throws Exception
    {
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
    */
}
