package com.pokercoaching.usersmicroservice.services;

import com.pokercoaching.usersmicroservice.data.UserEntity;
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
        UserEntity userEntity = mapper.map(userDetails,UserEntity.class);
        userRepository.save(userEntity);

        UserDto returnValue = mapper.map(userEntity,UserDto.class);
        return returnValue;
    }

    @Override
    public UserDto getUserDetailsByEmail(String email) {

        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null) throw new UsernameNotFoundException(email);

        return new ModelMapper().map(userEntity,UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(username);
        if(userEntity == null) throw new UsernameNotFoundException(username);
        return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(), true,true,true,true, new ArrayList<>());
    }

}
