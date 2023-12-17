package com.grh.service;

import com.grh.entites.Role;

import java.util.List;

public interface RoleserviceIn {
    public Role createRole(Role Role);
    public List<Role> finAllRole();
    public String updateRole(Role Role, Long id);
    public Boolean deleteRole(Long id);

}
