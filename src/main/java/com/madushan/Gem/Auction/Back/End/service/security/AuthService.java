package com.madushan.Gem.Auction.Back.End.service.security;

import com.madushan.Gem.Auction.Back.End.controller.AuthController;
import com.madushan.Gem.Auction.Back.End.dto.request.JwtResponse;
import com.madushan.Gem.Auction.Back.End.dto.request.LoginRequest;
import com.madushan.Gem.Auction.Back.End.entity.User;
import com.madushan.Gem.Auction.Back.End.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    public JwtResponse authenticate(LoginRequest request) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        User user = userService.findByUsername(request.getUsername());
        String token = jwtUtil.generateToken((UserDetails) authentication.getPrincipal());

        JwtResponse jwtResponse = new JwtResponse(token, user.getUsername(), user.getRoleName().name());
        LOGGER.info("User {} login successfully", jwtResponse.getUsername());
        return jwtResponse;
    }
}
