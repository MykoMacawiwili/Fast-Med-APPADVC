package com.csb.appadvcmidterms.services.impl;

import com.csb.appadvcmidterms.repository.RoleRepository;
import com.csb.appadvcmidterms.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Long getRoleId(String name) {
        return roleRepository.findByName(name).getId();
    }

}
