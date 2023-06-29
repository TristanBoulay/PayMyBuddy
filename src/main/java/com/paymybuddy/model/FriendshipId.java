package com.paymybuddy.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class FriendshipId implements Serializable
{
    private int senderUser;
    private int receiverUser;

    @Override
    public boolean equals(Object object)
    {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        FriendshipId that = (FriendshipId) object;
        return senderUser == that.senderUser && receiverUser == that.receiverUser;
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(senderUser, receiverUser);
    }
}

