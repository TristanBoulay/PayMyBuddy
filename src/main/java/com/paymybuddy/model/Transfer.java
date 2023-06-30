package com.paymybuddy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "Transfer")
public class Transfer {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String description;

    @Column
    private float amount;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    private Account senderAccount;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    private Account receiverAccount;

}
