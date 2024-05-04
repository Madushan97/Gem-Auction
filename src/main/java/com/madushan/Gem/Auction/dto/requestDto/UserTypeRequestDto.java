package com.madushan.Gem.Auction.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserTypeRequestDto {

    private String userTypeName;
    private String description;
}
