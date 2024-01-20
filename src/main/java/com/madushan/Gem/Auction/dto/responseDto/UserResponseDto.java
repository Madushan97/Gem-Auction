package com.madushan.Gem.Auction.dto.responseDto;

import com.madushan.Gem.Auction.model.Auction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
    private Boolean status;
    private Set<Auction> auction;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
