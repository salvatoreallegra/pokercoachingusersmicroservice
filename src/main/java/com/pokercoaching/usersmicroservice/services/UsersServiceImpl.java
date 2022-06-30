package com.pokercoaching.usersmicroservice.services;

import com.pokercoaching.usersmicroservice.shared.UserDto;

import java.util.UUID;

public class UsersServiceImpl implements UsersService {
    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        return null;
    }
}
