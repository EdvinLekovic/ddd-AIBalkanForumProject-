package com.example.usermanagement.domain.model;


import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.image.Image;
import com.example.usermanagement.domain.model.enumerations.Role;
import com.example.usermanagement.domain.ids.UserId;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "Ai_users")
@Getter
public class User extends AbstractEntity<UserId> implements UserDetails {

    private String username;

    private String name;

    private String lastname;

    private String password;

    private boolean isAccountNonExpired = true;

    private boolean isAccountNonLocked = true;

    private boolean isCredentialsNonExpired = true;

    private boolean isEnabled = true;

    @Enumerated(value = EnumType.STRING)
    private Role role;


    protected User() {
        super(UserId.randomId(UserId.class));
    }


    public User(String username,
                String name,
                String lastname,
                String password,
                Role role) {
        super(UserId.randomId(UserId.class));
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }
}
