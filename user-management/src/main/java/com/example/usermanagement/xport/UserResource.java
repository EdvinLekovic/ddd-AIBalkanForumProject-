package com.example.usermanagement.xport;

import com.example.usermanagement.config.util.JwtUtil;
import com.example.usermanagement.domain.ids.UserId;
import com.example.usermanagement.domain.model.User;
import com.example.usermanagement.domain.model.dto.AuthRequest;
import com.example.usermanagement.domain.model.dto.TokenRequest;
import com.example.usermanagement.service.UserService;
import com.example.usermanagement.service.forms.UserForm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:3000")
public class UserResource {

    private final UserService userService;

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    public UserResource(UserService userService,
                        JwtUtil jwtUtil,
                        AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/get-user-by-id")
    public ResponseEntity<User> getUserById(@RequestBody UserId userId){
        return userService.findByUserId(userId)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/user-expiration")
    public boolean userValidity(@RequestBody TokenRequest tokenRequest){
        Date timeNow = new Date();
        return jwtUtil.extractExpiration(tokenRequest.getToken()).getTime() > timeNow.getTime();
    }

    @PostMapping("/get-user-by-token")
    public ResponseEntity<User> getUserByToken(@RequestBody TokenRequest tokenRequest){
        String username = jwtUtil.extractUsername(tokenRequest.getToken());
        return userService.findByUserName(username).map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserForm userForm){
        return userService.register(userForm).map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()));
        }
        catch (Exception ex){
            throw new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
}
