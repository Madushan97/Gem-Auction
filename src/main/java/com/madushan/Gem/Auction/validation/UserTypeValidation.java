package com.madushan.Gem.Auction.validation;

import com.madushan.Gem.Auction.model.UserType;
import com.madushan.Gem.Auction.repository.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserTypeValidation {

    private final UserTypeRepository userTypeRepository;

    public Boolean isExistByUserTypeName(String userTypeName) {
         return userTypeRepository.existsUserTypeByUserTypeName(userTypeName);
    }

}
