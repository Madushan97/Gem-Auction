package com.madushan.Gem.Auction.Back.End.controller;

import com.madushan.Gem.Auction.Back.End.dto.request.JwtResponse;
import com.madushan.Gem.Auction.Back.End.dto.request.LoginRequest;
import com.madushan.Gem.Auction.Back.End.dto.request.RegisterRequest;
import com.madushan.Gem.Auction.Back.End.entity.User;
import com.madushan.Gem.Auction.Back.End.service.security.AuthService;
import com.madushan.Gem.Auction.Back.End.service.security.UserService;
import com.madushan.Gem.Auction.Back.End.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<StandardResponse> register(@RequestBody RegisterRequest request) {
        LOGGER.info("Request came to user register");
        User savedUser = userService.register(request);
        return new ResponseEntity<>(
                new StandardResponse(
                        HttpStatus.CREATED.value(),
                        "User registered successfully",
                        savedUser
                ),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        LOGGER.info("Request came to user login");
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
