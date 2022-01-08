package com.dataservice;

import com.datamodel.ERole;
import com.datamodel.Role;
import com.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    //processus metier

    @Autowired
    RoleRepository roleRepository;

    public Role findByName(ERole name){
        return roleRepository.findByName(name);
    }

    public Role createRole(Role role){
        return roleRepository.save(role);
    }
}
