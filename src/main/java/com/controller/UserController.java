package com.controller;

import com.datamodel.User;
import com.dataservice.UserIpml;
import com.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api")
public class UserController {

    @Autowired
    private IUserRepository iUserRepository;

    @GetMapping(value ="/users")
    public ResponseEntity <List<User>> getUsers(){
        return ResponseEntity.ok().body(iUserRepository.findAll());
    }

    @PostMapping(value = "/users")
    public User createUsers(@RequestBody  User user){
        UserIpml userIpml = new UserIpml();
        return userIpml.create(user);
    }
}
