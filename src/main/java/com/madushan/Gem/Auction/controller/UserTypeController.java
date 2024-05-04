package com.madushan.Gem.Auction.controller;

import com.madushan.Gem.Auction.dto.requestDto.UserTypeRequestDto;
import com.madushan.Gem.Auction.dto.responseDto.UserResponseDto;
import com.madushan.Gem.Auction.dto.responseDto.UserTypeResponseDto;
import com.madushan.Gem.Auction.service.UserTypeService;
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
@RequestMapping("/userType")
public class UserTypeController {

    private final Logger LOGGER = LoggerFactory.getLogger(UserTypeController.class);
    private final UserTypeService userTypeService;

    @GetMapping("/getAll")
    public ResponseEntity<StandardResponse> getAllUserTypes() {
        List<UserTypeResponseDto> userList = userTypeService.getAllUserTypes();
        LOGGER.info("Get all user types successfully");
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "Get all user types successfully",
                        userList
                ),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> createUserTypes(@RequestBody UserTypeRequestDto userTypeRequestDto) {
        UserTypeResponseDto userList = userTypeService.createUserTypes(userTypeRequestDto);
        LOGGER.info("Create User types successfully");
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.CREATED.value(),
                        "Create user types successfully",
                        userList
                ),
                HttpStatus.CREATED
        );
    }
}
