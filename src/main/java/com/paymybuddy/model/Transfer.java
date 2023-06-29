package com.paymybuddy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "Transfer")
public class Transfer
{
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String description;

    @Column
    private float amount;

    /*
    @ManyToOne(fetch=FetchType.EAGER, optional = false)
    @JsonManagedReference
    @JoinColumn(name = "sender_Account_Id")
    private Account senderAccount;

    @ManyToOne(fetch=FetchType.EAGER, optional = false)
    @JsonManagedReference
    @JoinColumn(name = "receiver_Account_Id")
    private Account receiverAccount;
    */
}
