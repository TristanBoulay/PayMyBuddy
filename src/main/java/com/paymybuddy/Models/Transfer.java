package com.paymybuddy.Models;

import jakarta.persistence.*;

@Entity
@Table( name = "Transfer")
public class Transfer {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String description;

    @Column
    private float amount;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    private Account senderAccount;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    private Account receiverAccount;

}
