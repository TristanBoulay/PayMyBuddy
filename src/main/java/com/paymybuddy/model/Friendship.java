package com.paymybuddy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Friendship")
public class

Friendship
{
    @EmbeddedId
    private FriendshipId id;

}
