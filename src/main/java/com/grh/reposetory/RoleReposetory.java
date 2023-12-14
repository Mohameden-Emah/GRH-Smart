package com.grh.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grh.entites.Role;

public interface RoleReposetory extends JpaRepository<Role, Long> {

}
