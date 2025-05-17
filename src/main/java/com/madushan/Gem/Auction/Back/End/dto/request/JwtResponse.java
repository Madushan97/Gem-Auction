package com.madushan.Gem.Auction.Back.End.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwtResponse {

    private String token;
    private String username;
    private String role;
}
