package com.pokercoaching.usersmicroservice.controllers;

import com.pokercoaching.usersmicroservice.models.CreateUserRequestModel;
import com.pokercoaching.usersmicroservice.models.CreateUserResponseModel;
import com.pokercoaching.usersmicroservice.services.UsersService;
import com.pokercoaching.usersmicroservice.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel user){
        //Create Mapper
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy((MatchingStrategies.STRICT));

        //Map incoming post request data user object into dto
        UserDto userDto = mapper.map(user,UserDto.class);

        UserDto createdUser = usersService.createUser(userDto);



        CreateUserResponseModel returnValue = mapper.map(createdUser,CreateUserResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }
}
