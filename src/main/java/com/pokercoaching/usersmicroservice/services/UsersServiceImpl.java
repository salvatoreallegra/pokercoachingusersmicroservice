package com.pokercoaching.usersmicroservice.services;

import com.pokercoaching.usersmicroservice.data.Users;
import com.pokercoaching.usersmicroservice.data.UserRepository;
import com.pokercoaching.usersmicroservice.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    public UsersServiceImpl(){
        this.userRepository = userRepository;
    }
    @Override
    public UserDto createUser(UserDto userDetails) {

        userDetails.setUserId(UUID.randomUUID().toString());
        userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy((MatchingStrategies.STRICT));
        Users users = mapper.map(userDetails, Users.class);
        userRepository.save(users);

        UserDto returnValue = mapper.map(users,UserDto.class);
        return returnValue;
    }

    @Override
    public UserDto getUserDetailsByEmail(String email) {

        Users users = userRepository.findByEmail(email);
        if(users == null) throw new UsernameNotFoundException(email);

        return new ModelMapper().map(users,UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = userRepository.findByEmail(username);
        if(users == null) throw new UsernameNotFoundException(username);
        return new User(users.getEmail(), users.getEncryptedPassword(), true,true,true,true, new ArrayList<>());
    }

    @Override
    public UserDto getUserByUserId(String userId) {

        Users userEntity = userRepository.findByUserId(userId);
        if(userEntity == null) throw new UsernameNotFoundException("User not found");

        UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);

        return userDto;
    }


}
