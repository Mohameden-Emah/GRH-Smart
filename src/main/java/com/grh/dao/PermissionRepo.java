package com.grh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grh.entity.Permission;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, Long> {
    boolean existsByName(String name);
}