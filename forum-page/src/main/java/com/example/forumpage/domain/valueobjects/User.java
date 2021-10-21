package com.example.forumpage.domain.valueobjects;

import com.example.sharedkernel.domain.base.ValueObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class User implements ValueObject {

    private final UserId userId;
    private final String username;
    private final String name;
    private final String lastname;
    private final String password;

    protected User() {
        this.userId = UserId.randomId(UserId.class);
        this.username = "";
        this.name = "";
        this.lastname = "";
        this.password = "";
    }

    @JsonCreator
    public User(@JsonProperty("userId") UserId userId,
                @JsonProperty("username") String username,
                @JsonProperty("name") String name,
                @JsonProperty("lastname") String lastname,
                @JsonProperty("password") String password) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
    }
}
