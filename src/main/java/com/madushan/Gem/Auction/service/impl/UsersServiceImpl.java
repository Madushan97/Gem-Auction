package com.madushan.Gem.Auction.service.impl;

import com.madushan.Gem.Auction.controller.UserController;
import com.madushan.Gem.Auction.dto.requestDto.UserRequestDto;
import com.madushan.Gem.Auction.dto.responseDto.UserResponseDto;
import com.madushan.Gem.Auction.model.User;
import com.madushan.Gem.Auction.repository.UserRepository;
import com.madushan.Gem.Auction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UsersServiceImpl.class);

    private final UserRepository userRepository;

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> userList = userRepository.findAllByActiveStatus(true);
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        if (userList.size() > 0) {
            LOGGER.info("Active users getting successfully, user List size : {}", userList.size());
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
            LOGGER.info("User list sent successfully");
        } else {
            LOGGER.warn("User list is empty");
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
        LOGGER.info("User create successfully");
        return "User ID : "+ user.getId() + ", saved.";
    }

    @Override
    public String deleteUser(int userId) {
        User user = userRepository.findByIdAndActiveStatus(userId, true);
        LOGGER.info("User ID : {} fetch successfully", userId);
        if (user != null) {
            userRepository.deleteById(userId);
            LOGGER.info("User ID : {} delete successfully", userId);
        }
        LOGGER.error("User ID : {} is null", userId);
        return "Delete ID : " + userId + ", successfully";
    }
}
