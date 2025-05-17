package com.madushan.Gem.Auction.Back.End.entity;

import com.madushan.Gem.Auction.Back.End.util.RoleName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String fullName;

    private boolean enabled = true;
    private boolean verified = false;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    private Instant createdAt;
}
