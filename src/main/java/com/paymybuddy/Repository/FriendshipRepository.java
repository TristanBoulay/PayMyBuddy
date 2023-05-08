package com.paymybuddy.Repository;

import com.paymybuddy.Models.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    Optional<Friendship> findBySenderUserAndReceiverUser(Long userId, Long friendId);

    List<Friendship> findAllBySenderUserOrReceiverUser(Long userId, Long friendId);
}

