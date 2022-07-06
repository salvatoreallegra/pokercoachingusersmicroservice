package com.pokercoaching.usersmicroservice.services;

import com.pokercoaching.usersmicroservice.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {
    UserDto createUser(UserDto userDetails);
}
