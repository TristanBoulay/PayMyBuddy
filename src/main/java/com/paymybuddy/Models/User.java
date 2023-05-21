package com.paymybuddy.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
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
                    joinColumns = @JoinColumn( name = "receiverUser" ),
                    inverseJoinColumns = @JoinColumn( name = "senderUser" ) )
    private List<Friendship> friends = new ArrayList<>();

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Account account;



}
