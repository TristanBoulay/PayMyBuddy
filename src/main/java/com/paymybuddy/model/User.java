package com.paymybuddy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name="User")
public class User implements UserDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    // TODO : mettre en place une enum
    @Column
    private String role;

    public User(User user)
    {
    }

    public User()
    {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return null;
    }

    @Override
    public String getUsername()
    {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

    /*
    @ManyToMany
    @JoinTable
            ( name = "Friendship",
                    joinColumns = @JoinColumn( name = "receiverUser",referencedColumnName = "id" ),
                    inverseJoinColumns = @JoinColumn( name = "senderUser",referencedColumnName = "id"  ) )


    private List<User> friends = new ArrayList<>();

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Account account;
    */


}
