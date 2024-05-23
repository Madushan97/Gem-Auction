package com.madushan.Gem.Auction.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_type")
@Data
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_type", nullable = false)
    private String userTypeName;

    @Column(name = "description", nullable = true)
    private String description;

    @OneToMany(mappedBy = "userType")
    @JsonBackReference
    private List<User> users;
}
