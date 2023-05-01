package com.paymybuddy.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table ( name = "Account")
public class Account {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn (name = "account_id")
    List <Transaction> transactions = new ArrayList<>();


}
