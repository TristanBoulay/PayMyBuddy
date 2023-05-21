package com.paymybuddy.Repository;

import com.paymybuddy.Models.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {


}

