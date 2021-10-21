package com.example.usermanagement.service.forms;

import com.example.sharedkernel.domain.image.Image;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserForm {

    @NotNull
    private String username;

    @NotNull
    private String name;

    @NotNull
    private String lastname;

    @NotNull
    private String password;

    @NotNull
    private String repeatPassword;

    public UserForm(String username, String name, String lastname, String password, String repeatPassword) {
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

}
