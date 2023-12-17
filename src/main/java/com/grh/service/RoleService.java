package com.grh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grh.entites.Role;
import com.grh.reposetory.RoleReposetory;

@Service
public class RoleService implements RoleserviceIn {
    @Autowired
    private RoleReposetory repository;


    @Override
    public Role createRole(Role Role) {
        return repository.save(Role);
    }

    @Override
    public List<Role> finAllRole() {
        return repository.findAll();
    }

    @Override
    public String updateRole(Role updatedRole, Long id) {
        Optional<Role> existingRoleOptional = repository.findById(id);
    
        if (existingRoleOptional.isPresent()) {
            Role existingRole = existingRoleOptional.get();
            existingRole.setName(updatedRole.getName());
            
    
            repository.save(existingRole);
            
            return "Role est modified";
        } else {
            return "Role not exist";
        }
    }

    @Override
    public Boolean deleteRole(Long id) {
        Optional<Role> RoleOptional = repository.findById(id);
        if(RoleOptional.isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
