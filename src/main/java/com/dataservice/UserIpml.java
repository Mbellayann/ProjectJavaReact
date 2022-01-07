package com.dataservice;

import com.datamodel.User;
import com.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserIpml {
    @Autowired
    IUserRepository iUserRepository;

    public User create(User user){

        return iUserRepository.save(user);
    }
}
