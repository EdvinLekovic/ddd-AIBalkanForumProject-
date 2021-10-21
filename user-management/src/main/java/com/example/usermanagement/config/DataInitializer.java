package com.example.usermanagement.config;

import com.example.usermanagement.domain.model.User;
import com.example.usermanagement.domain.model.enumerations.Role;
import com.example.usermanagement.service.UserService;
import com.example.usermanagement.service.forms.UserForm;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
public class DataInitializer {

    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initAdmins() {
        Optional<User> user1 = userService.findByUserName("edvin12");
        if (user1.isEmpty()) {
            UserForm userForm = new UserForm("edvin12", "Edvin", "Lekovic", "edvin", "edvin");
            this.userService.register(userForm);
        }
    }
}
