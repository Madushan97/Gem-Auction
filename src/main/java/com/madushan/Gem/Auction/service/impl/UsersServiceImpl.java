package com.madushan.Gem.Auction.service.impl;

import com.madushan.Gem.Auction.dto.requestDto.UserRequestDto;
import com.madushan.Gem.Auction.dto.responseDto.UserResponseDto;
import com.madushan.Gem.Auction.model.User;
import com.madushan.Gem.Auction.repository.UserRepository;
import com.madushan.Gem.Auction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> userList = userRepository.findAllByActiveStatus(true);

        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        for (User user : userList) {
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setId(user.getId());
            userResponseDto.setUsername(user.getUsername());
            userResponseDto.setEmail(user.getEmail());
            userResponseDto.setPassword(user.getPassword());
            userResponseDto.setAddress(user.getAddress());
            userResponseDto.setPhoneNumber(user.getPhoneNumber());
            userResponseDto.setActiveStatus(user.getActiveStatus());
            userResponseDto.setAuction(user.getAuction());
            userResponseDto.setCreatedAt(user.getCreatedAt());
            userResponseDto.setUpdatedAt(user.getUpdatedAt());
            userResponseDtoList.add(userResponseDto);
        }
        return userResponseDtoList;
    }

    @Override
    public String createUser(UserRequestDto userRequestDto) {
        User user = new User();

        user.setId(userRequestDto.getId());
        user.setUsername(userRequestDto.getUsername());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setAddress(userRequestDto.getAddress());
        user.setPhoneNumber(userRequestDto.getPhoneNumber());
        user.setActiveStatus(userRequestDto.getActiveStatus());
        user.setAuction(userRequestDto.getAuction());
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());

        userRepository.save(user);
        return "User "+ user.getId() + " saved.";
    }
}
