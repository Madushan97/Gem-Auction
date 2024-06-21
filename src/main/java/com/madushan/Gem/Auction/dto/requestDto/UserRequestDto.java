package com.madushan.Gem.Auction.dto.requestDto;

import com.madushan.Gem.Auction.model.auction.Auction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDto {

    private String username;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private Boolean activeStatus;
    private Set<Auction> auction;
    private String userType;
}
