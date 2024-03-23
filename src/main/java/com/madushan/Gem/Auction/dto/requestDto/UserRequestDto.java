package com.madushan.Gem.Auction.dto.requestDto;

import com.madushan.Gem.Auction.model.Auction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDto {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private Boolean activeStatus;
    private Set<Auction> auction;
}
