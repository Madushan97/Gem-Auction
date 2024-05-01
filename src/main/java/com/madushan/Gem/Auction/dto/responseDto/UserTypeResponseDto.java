package com.madushan.Gem.Auction.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserTypeResponseDto {

    private int id;
    private String userTypeName;
    private String description;
}
