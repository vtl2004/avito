package com.avito.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String login;   //email is login
    //!notice! check use regexp valid email!

    private String publicName;   //viewe from any user name
    //check if word not in blacklist.

    @Size(min=5, message = "пароль должен быть более 5 символов!")
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    private String userIcons;


    //constructors
    public User() {};

    public User(@Email String login, String publicName, String password, String passwordConfirm, Set<Role> roles) {
        this.login = login;
        this.publicName = publicName;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.roles = roles;
    }

    //Override methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}