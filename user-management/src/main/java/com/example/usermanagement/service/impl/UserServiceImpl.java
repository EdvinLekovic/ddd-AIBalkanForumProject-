package com.example.usermanagement.service.impl;

import com.example.usermanagement.domain.ids.UserId;
import com.example.usermanagement.domain.model.User;
import com.example.usermanagement.domain.model.enumerations.Role;
import com.example.usermanagement.domain.model.exceptions.InvalidPasswordException;
import com.example.usermanagement.domain.model.exceptions.InvalidUsernameException;
import com.example.usermanagement.domain.model.exceptions.PasswordsDoNotMatchException;
import com.example.usermanagement.domain.model.exceptions.UsernameAlreadyExistsException;
import com.example.usermanagement.domain.repository.UserRepository;
import com.example.usermanagement.service.UserService;
import com.example.usermanagement.service.forms.UserForm;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> register(UserForm userForm) {
        if (userForm.getUsername() == null || userForm.getUsername().isEmpty())
            throw new InvalidUsernameException();

        if (userForm.getPassword() == null || userForm.getPassword().isEmpty())
            throw new InvalidPasswordException();

        if (this.userRepository.findByUsername(userForm.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException(userForm.getUsername());
        }

        if (!userForm.getPassword().equals(userForm.getRepeatPassword())) {
            throw new PasswordsDoNotMatchException();
        }

        User user =  userRepository.save(new User(
                userForm.getUsername(),
                userForm.getName(),
                userForm.getLastname(),
                passwordEncoder.encode(userForm.getPassword()),
                Role.ROLE_USER));

        return Optional.of(user);
    }

    @Override
    public Optional<User> findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByUserId(UserId userId) {
        return userRepository.findById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s).get();
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getAuthorities());
    }
}
