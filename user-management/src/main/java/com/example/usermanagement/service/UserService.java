package com.example.usermanagement.service;

import com.example.usermanagement.domain.ids.UserId;
import com.example.usermanagement.domain.model.User;
import com.example.usermanagement.service.forms.UserForm;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> register(UserForm userForm);
    Optional<User> findByUserName(String username);
    Optional<User> findByUserId(UserId userId);
}
