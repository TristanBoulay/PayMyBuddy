package com.paymybuddy.Models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column
    private float amount;


}
