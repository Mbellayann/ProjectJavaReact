package com.controller;

import com.datamodel.Address;
import com.datamodel.Contact;
import com.datamodel.Role;
import com.datamodel.User;
import com.dataservice.AddressService;
import com.dataservice.ContactService;
import com.dataservice.RoleService;
import com.dataservice.UserServiceImpl;
import com.dto.ContactDto;
import com.dto.LoginDto;
import com.dto.UserDto;
import com.exceptions.ResourceNotFoundException;
import com.repository.IUserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ContactService contactService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping(value = "/users")
    @RolesAllowed("admin")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userServiceImpl.getUsers());
    }

    @PostMapping(value = "/registerusers")
    @RolesAllowed("admin")
    public ResponseEntity<User> registerUsers(@RequestBody UserDto userDto) {
        System.out.println(userDto.getPassword() + " " + userDto.getPasswordConfirmed());
        /*if(!userDto.getPassword().equals(userDto.getPasswordConfirmed())){
            return new ResponseEntity("Bad request password and password not confirm", HttpStatus.BAD_REQUEST);
        }else if (userDto.getPassword() == userDto.getPasswordConfirmed())
        {*/
        System.out.println("ici");
        Set<Role> listRoles = new HashSet<>();
        userDto.getRoles().forEach(role -> {
            listRoles.add(roleService.findByName(role));
        });
        User user = userDto.MapUser();
        Address address = new Address(userDto.getCountry(), userDto.getArea(), userDto.getCity(),
                userDto.getStreet(), userDto.getNumber());
        addressService.saveAddress(address);
        ContactDto contactDto = new ContactDto();
        Contact contact = contactDto.MapContact(userDto.getName(), userDto.getBirthDay(),
                userDto.getGender(), userDto.getEmail());
        System.out.println(user);
        user.setRoles(listRoles);
        userServiceImpl.SaveUser(user);
        contactService.saveContact(contact, user, address);
        return ResponseEntity.ok().body(user);
        /*}
        return null;*/
    }

    @PutMapping(value = "/users/{userID}", produces = "application/json")
    @RolesAllowed("admin")
    public ResponseEntity<User> updateUser(@PathVariable(value = "userID") Long userID,
                                           @Validated @RequestBody UserDto userDto) throws ResourceNotFoundException {
        try {
            User users = iUserRepository.findById(userID)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userID));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(userID);
        User user = userDto.MapUser();
        User user1 = userServiceImpl.getUser(userDto.getUsername());
        ContactDto contactDto = new ContactDto();
        Address address = new Address(userDto.getCountry(), userDto.getArea(), userDto.getCity(),
                userDto.getStreet(), userDto.getNumber());
        Contact contact1 = contactService.findByUser(user1);
        contact1.setName(userDto.getName());
        contact1.setBirthDay(userDto.getBirthDay());
        contact1.setGender(userDto.getGender());
        contact1.setEmail(userDto.getEmail());
        addressService.saveAddress(address);
        userServiceImpl.SaveUser(user);
        contactService.saveContact(contact1, user, address);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(value = "/login")
    public @ResponseBody Set<Role> loginUser(@RequestBody LoginDto loginDto){
        User user = userServiceImpl.getUser(loginDto.getUsername());
        System.out.println(user.getPassword());
        Set<Role> listRoles = new HashSet<>();
        if (userServiceImpl.Checking(user, loginDto.getPassword())){
            System.out.println("inside ");
            user.getRoles().forEach(role -> {
                listRoles.add(roleService.findByName(role.getName()));
            });
            System.out.println("inside here");
            return listRoles;
        }else {
            System.out.println("ici");
            return null;
        }
    }
}
