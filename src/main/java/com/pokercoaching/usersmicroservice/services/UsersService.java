package com.pokercoaching.usersmicroservice.services;

import com.pokercoaching.usersmicroservice.shared.UserDto;

public interface UsersService {
    UserDto createUser(UserDto userDetails);
}
