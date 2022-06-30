package com.pokercoaching.usersmicroservice.controllers;

import com.pokercoaching.usersmicroservice.models.CreateUserRequestModel;
import com.pokercoaching.usersmicroservice.services.UsersService;
import com.pokercoaching.usersmicroservice.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment env;

    @Autowired
    UsersService usersService;
    @GetMapping("/status/check")
    public String status(){
        return "Working on port " + env.getProperty("local.server.port");
    }

    @PostMapping
    public String createUser(@Valid @RequestBody CreateUserRequestModel user){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy((MatchingStrategies.STRICT));
        UserDto userDto = mapper.map(user,UserDto.class);
        usersService.createUser(userDto);
        return "Called create user method";
    }
}
