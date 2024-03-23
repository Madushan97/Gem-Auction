package com.madushan.Gem.Auction.dto.responseDto;

import com.madushan.Gem.Auction.model.Auction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDto {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private Boolean activeStatus;
    private Set<Auction> auction;
    private Date createdAt;
    private Date updatedAt;
}
