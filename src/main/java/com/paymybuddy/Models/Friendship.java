package com.paymybuddy.Models;

import jakarta.persistence.*;

@Entity
@Table
public class Friendship {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;


}
