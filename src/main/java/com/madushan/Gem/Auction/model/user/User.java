package com.madushan.Gem.Auction.model.user;

import com.madushan.Gem.Auction.model.auction.Auction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "active_status", length = 20)
    private Boolean activeStatus;

    @ManyToMany(mappedBy = "users")
    private Set<Auction> auctions;

    @ManyToOne
    @JoinColumn(name = "user_type_id", nullable = false)
    private UserType userType;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = true, length = 20)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = true, length = 20)
    private Date updatedAt;
}
