package com.avito.controllers.rest;

import com.avito.models.Role;
import com.avito.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleRestController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/get")
    public Role getRole(Role role) {
        return roleService.findRoleByName(role.getRole());
    }
}
