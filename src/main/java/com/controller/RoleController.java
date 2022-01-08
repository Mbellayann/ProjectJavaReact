package com.controller;

import com.datamodel.Role;
import com.dataservice.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/api")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping(value ="/roles")
    public Role createRole (@RequestBody Role role){
        return roleService.createRole(role);
    }

}
