package com.example.usermanagement.domain.repository;

import com.example.usermanagement.domain.ids.UserId;
import com.example.usermanagement.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, UserId> {
    Optional<User> findByUsername(String username);
}
