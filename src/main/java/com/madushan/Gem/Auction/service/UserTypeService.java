package com.madushan.Gem.Auction.service;

import com.madushan.Gem.Auction.dto.requestDto.UserTypeRequestDto;
import com.madushan.Gem.Auction.dto.responseDto.UserTypeResponseDto;

import java.util.List;

public interface UserTypeService {

    List<UserTypeResponseDto> getAllUserTypes();
    UserTypeResponseDto createUserTypes(UserTypeRequestDto userTypeRequestDto);
}
