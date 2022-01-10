package com.dataservice;

import com.datamodel.ERole;
import com.datamodel.User;

import java.util.List;

public interface UserService {
    User SaveUser(User user);
    void AddRoleToUser(String username, ERole role);
    User getUser(String username);
    List<User>getUsers();
}
