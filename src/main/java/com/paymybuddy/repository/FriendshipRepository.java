package com.paymybuddy.repository;

import com.paymybuddy.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipRepository extends JpaRepository<Friendship, Long>
{
    //Optional<User> findByName(String name);
}
