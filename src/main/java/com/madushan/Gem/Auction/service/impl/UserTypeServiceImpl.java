package com.madushan.Gem.Auction.service.impl;

import com.madushan.Gem.Auction.dto.responseDto.UserTypeResponseDto;
import com.madushan.Gem.Auction.model.UserType;
import com.madushan.Gem.Auction.repository.UserTypeRepository;
import com.madushan.Gem.Auction.service.UserTypeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTypeServiceImpl implements UserTypeService {

    private final UserTypeRepository userTypeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserTypeResponseDto> getAllUserTypes() {
        List<UserType> userTypeList = userTypeRepository.findAll();
        List<UserTypeResponseDto> userTypeResponseDtoList = new ArrayList<>();
        for (UserType userType : userTypeList) {
            UserTypeResponseDto userTypeResponseDto = modelMapper.map(userType, UserTypeResponseDto.class);
            userTypeResponseDtoList.add(userTypeResponseDto);
        }
        return userTypeResponseDtoList;
    }
}