package com.pokercoaching.usersmicroservice.services;

import com.pokercoaching.usersmicroservice.data.UserEntity;
import com.pokercoaching.usersmicroservice.data.UserRepository;
import com.pokercoaching.usersmicroservice.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
        UserEntity userEntity = mapper.map(userDetails,UserEntity.class);
        userRepository.save(userEntity);

        UserDto returnValue = mapper.map(userEntity,UserDto.class);
        return returnValue;
    }
}
