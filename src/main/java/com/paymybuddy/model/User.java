package com.paymybuddy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @ManyToMany
    @JoinTable
            ( name = "Friendship",
                    joinColumns = @JoinColumn( name = "receiverUser",referencedColumnName = "id" ),
                    inverseJoinColumns = @JoinColumn( name = "senderUser",referencedColumnName = "id"  ) )
    private List<User> friends = new ArrayList<>();

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Account account;



}
