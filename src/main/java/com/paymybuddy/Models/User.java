package com.paymybuddy.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @ManyToMany
    @JoinTable
            ( name = "Friendship",
                    joinColumns = @JoinColumn( name = "receiverUser_id" ),
                    inverseJoinColumns = @JoinColumn( name = "senderUser_id" ) )
    private List<Friendship> friendshipList = new ArrayList<>();

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Account account;



}
