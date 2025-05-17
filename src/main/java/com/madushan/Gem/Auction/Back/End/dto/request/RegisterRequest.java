package com.madushan.Gem.Auction.Back.End.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequest {

    private String username;
    private String email;
    private String password;
    private String fullName;
}
