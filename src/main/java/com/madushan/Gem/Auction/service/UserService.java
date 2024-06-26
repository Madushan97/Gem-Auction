package com.madushan.Gem.Auction.service;

import com.madushan.Gem.Auction.dto.requestDto.UserRequestDto;
import com.madushan.Gem.Auction.dto.responseDto.UserResponseDto;

import java.util.List;

public interface UserService {

    List<UserResponseDto> getAllUsers();
    String createUser(UserRequestDto userRequestDto);
    String deleteUser(int userId);
    UserResponseDto updateUser(int userId, UserRequestDto userRequestDto);
    UserResponseDto getUserById(int userId);
}
