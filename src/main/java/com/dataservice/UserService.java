package com.dataservice;

import com.datamodel.User;
import com.repository.IUserRepository;
import com.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IUserRepository iUserRepository;

    public User create(User user){
        return iUserRepository.save(user);
    }
}
