package com.paymybuddy.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
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
