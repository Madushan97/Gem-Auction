package com.madushan.Gem.Auction.Back.End.service.security;

import com.madushan.Gem.Auction.Back.End.dto.request.RegisterRequest;
import com.madushan.Gem.Auction.Back.End.entity.User;
import com.madushan.Gem.Auction.Back.End.repository.UserRepository;
import com.madushan.Gem.Auction.Back.End.util.RoleName;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFullName(request.getFullName());
        user.setRoleName(RoleName.ROLE_ADMIN);

        user.setCreatedAt(Instant.now());
        User savedUser = userRepository.save(user);
        LOGGER.info("User : {} successfully saved id : {}", savedUser.getUsername(), savedUser.getId());
        return savedUser;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username: " + username)
        );
    }
}
