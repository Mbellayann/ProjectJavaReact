package com.controller;

import com.datamodel.Role;
import com.datamodel.User;
import com.dataservice.RoleService;
import com.dataservice.UserServiceImpl;
import com.dto.UserDto;
import com.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value ="/api")
public class UserController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping(value ="/users")
    public ResponseEntity <List<User>> getUsers(){
        return ResponseEntity.ok().body(userServiceImpl.getUsers());
    }

    @PostMapping(value = "/users")
    public User createUsers(@RequestBody UserDto userDto){
        Set<Role> listRoles = new HashSet<>();
        userDto.getRoles().forEach(role ->{
            listRoles.add(roleService.findByName(role));
        });
        User user = userDto.MapUser();
        System.out.println(user);
        user.setRoles(listRoles);
        return userServiceImpl.SaveUser(user);
    }
}
