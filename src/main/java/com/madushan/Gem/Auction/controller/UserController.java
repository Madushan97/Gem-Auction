package com.madushan.Gem.Auction.controller;

import com.madushan.Gem.Auction.dto.requestDto.UserRequestDto;
import com.madushan.Gem.Auction.dto.responseDto.UserResponseDto;
import com.madushan.Gem.Auction.service.UserService;
import com.madushan.Gem.Auction.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<StandardResponse> getAllUsers() {
        List<UserResponseDto> userList = userService.getAllUsers();
        LOGGER.info("Get all users successfully");
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "Get all users successfully",
                        userList
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<StandardResponse> getUser(@PathVariable(value = "id")int userId) {
        UserResponseDto user = userService.getUserById(userId);
        LOGGER.info("Get user {} successfully", userId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "Get user successfully",
                        user
                ),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> createUser(@RequestBody UserRequestDto userRequestDto) {
        String userList = userService.createUser(userRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.CREATED.value(),
                        "Create user successfully",
                        userList
                ),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StandardResponse> deleteUser(@PathVariable(value = "id")int userId) {
        String deleteStatus = userService.deleteUser(userId);
        LOGGER.info("Delete user {} successfully", userId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "Delete user successfully",
                        deleteStatus
                ),
                HttpStatus.OK
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StandardResponse> updateUser(@PathVariable(value = "id")int userId, @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto updatedUser = userService.updateUser(userId, userRequestDto);
        LOGGER.info("Update user {} successfully", userId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "Update user successfully",
                        updatedUser
                ),
                HttpStatus.OK
        );
    }
}
