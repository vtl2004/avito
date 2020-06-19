package com.avito.service.impl;

import com.avito.service.interfaces.ServiceRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRoleImp implements ServiceRole {
    @Autowired
    private final RoleDao roleDao;

    @Override
    public Role findRoleByName(String name) {
        return roleDao.findRoleByName(name);
    }
}
