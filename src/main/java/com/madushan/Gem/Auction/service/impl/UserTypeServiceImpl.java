package com.madushan.Gem.Auction.service.impl;

import com.madushan.Gem.Auction.dto.requestDto.UserTypeRequestDto;
import com.madushan.Gem.Auction.dto.responseDto.UserTypeResponseDto;
import com.madushan.Gem.Auction.exception.UserTypeExistException;
import com.madushan.Gem.Auction.model.user.UserType;
import com.madushan.Gem.Auction.repository.UserTypeRepository;
import com.madushan.Gem.Auction.service.UserTypeService;
import com.madushan.Gem.Auction.validation.UserTypeValidation;
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
    private final UserTypeValidation userTypeValidation;

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

    @Override
    public UserTypeResponseDto createUserTypes(UserTypeRequestDto userTypeRequestDto) {
        if (userTypeValidation.isExistByUserTypeName(userTypeRequestDto.getUserTypeName())) {
            throw new UserTypeExistException("User Type already exists");
        }
        UserType userType = modelMapper.map(userTypeRequestDto, UserType.class);
        userTypeRepository.save(userType);
        return modelMapper.map(userType, UserTypeResponseDto.class);
    }

}
