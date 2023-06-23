package com.paymybuddy.repository;

import com.paymybuddy.model.Friendship;
import com.paymybuddy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<Friendship, Long>
{
    //Optional<User> findByName(String name);
}
