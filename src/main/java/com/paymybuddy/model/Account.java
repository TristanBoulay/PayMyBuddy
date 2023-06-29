package com.paymybuddy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table ( name = "Account")
public class Account
{
    @Id
    @GeneratedValue
    private Long id;

    /*
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn (name = "userId")
    @JsonManagedReference
    List <Transaction> transactions = new ArrayList<>();
    */
}
