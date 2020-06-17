package com.avito.dao.impl;

import com.avito.models.dto.Role;
import com.avito.dao.interfaces.RoleDao;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role findRoleByName(String name) {
        return entityManager.createQuery("from Role where role = : name", Role.class)
                .setParameter("role", name)
                .getResultList().get(0);
    }
}
