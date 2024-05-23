package com.madushan.Gem.Auction.service.impl;

import com.madushan.Gem.Auction.dto.requestDto.UserRequestDto;
import com.madushan.Gem.Auction.dto.responseDto.UserResponseDto;
import com.madushan.Gem.Auction.exception.UserNotFoundException;
import com.madushan.Gem.Auction.model.User;
import com.madushan.Gem.Auction.model.UserType;
import com.madushan.Gem.Auction.repository.UserRepository;
import com.madushan.Gem.Auction.repository.UserTypeRepository;
import com.madushan.Gem.Auction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UsersServiceImpl.class);

    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;
    private final ModelMapper modelMapper;

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
                userResponseDto.setAuction(user.getAuctions());
                userResponseDto.setUserType(user.getUserType());
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

        user.setUsername(userRequestDto.getUsername());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setAddress(userRequestDto.getAddress());
        user.setPhoneNumber(userRequestDto.getPhoneNumber());
        user.setActiveStatus(userRequestDto.getActiveStatus());
        user.setAuctions(userRequestDto.getAuction());
        user.setUserType(userRequestDto.getUserType());
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

    @Override
    public UserResponseDto updateUser(int userId, UserRequestDto userRequestDto) {
        Optional<User> existingUser = userRepository.findById(userId);
        User currentUser = existingUser.get();
        if (existingUser.isPresent()) {
            currentUser.setId(userId);
            currentUser.setEmail(userRequestDto.getEmail());
            currentUser.setAuctions(userRequestDto.getAuction());
            currentUser.setUsername(userRequestDto.getUsername());
            currentUser.setActiveStatus(userRequestDto.getActiveStatus());
            currentUser.setAddress(userRequestDto.getAddress());
            currentUser.setPassword(userRequestDto.getPassword());
            currentUser.setCreatedAt(currentUser.getCreatedAt());
            currentUser.setPhoneNumber(userRequestDto.getPhoneNumber());

            userRepository.save(currentUser);
        }

        return modelMapper.map(currentUser, UserResponseDto.class);
    }

    @Override
    public UserResponseDto getUserById(int userId) {
        return userRepository.findById(userId)
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
    }

}
