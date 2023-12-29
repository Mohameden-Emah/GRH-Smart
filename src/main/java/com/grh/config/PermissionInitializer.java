package com.grh.config;

import java.util.Optional;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.grh.dao.AppUserRepo;
import com.grh.dao.PermissionRepo;
import com.grh.dao.RoleRepo;
import com.grh.entity.AppUser;
import com.grh.entity.Permission;
import com.grh.entity.Role;

@Component
public class PermissionInitializer implements ApplicationRunner {

    @Autowired
    private final PermissionRepo permissionRepository;

    @Autowired
    private final RoleRepo roleRepository;

    @Autowired
    private AppUserRepo userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public PermissionInitializer(PermissionRepo permissionRepository, RoleRepo roleRepository,
            AppUserRepo userInfoRepository,
            PasswordEncoder passwordEncoder) {
        this.permissionRepository = permissionRepository;
        this.roleRepository = roleRepository;
        this.userInfoRepository = userInfoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {
        String[] perm_list = { "add_conge","list_conge","delete_conge","get_dep_by_emp","list_dep","add_dep","delete_dep","list_emp","add_emp","update_emp","delete_emp", "list_role", "view_role", "create_role", "update_role", "delete_role",
                "list_permission", "view_permission", "create_permission", "update_permission", "delete_permission",
                "list_user", "update_user_password", "update_user_role", "delete_user", "list_account", "view_account","create_permission", 
                "update_user_password", "get_profile", "update_profile","create_company","view_company"
        };
        
        for (String perm : perm_list) {
            createPermissionIfNotFound(perm);
        }


        createSuperAdminRole("super_admin");
        createSuperUser("admin", "admin", "admin@admin.com");
        // createAgentRole();


    }

    @Transactional
    public void createPermissionIfNotFound(String name) {
        if (!permissionRepository.existsByName(name)) {
            Permission permission = new Permission();
            permission.setName(name);
            permissionRepository.save(permission);
        }
    }

    @Transactional
    public void createSuperUser(String username, String password, String email) {
        Optional<AppUser> user1 = userInfoRepository.findByUsername(username);
        Optional<AppUser> user2 = userInfoRepository.findByEmail(email);
        if (user1.isPresent() || user2.isPresent()) {
            AppUser user = user1.isPresent() ? user1.get() : user2.get();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(roleRepository.findByName("super_admin"));
            userInfoRepository.save(user);
        } else {
            AppUser user = new AppUser();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(roleRepository.findByName("super_admin"));
            user.setEmail(email);
            userInfoRepository.save(user);
        }
    }

    @Transactional
    public void createSuperAdminRole(String name) {
        Role superAdminRole = roleRepository.findByName(name);
        if (superAdminRole == null) {
            // Create new super admin role if it does not exist
            superAdminRole = new Role();
            superAdminRole.setName(name);
            superAdminRole.setPermissions(permissionRepository.findAll());
            roleRepository.save(superAdminRole);
        } else {
            // Update existing super admin role by adding super user permission
            superAdminRole.setPermissions(permissionRepository.findAll());
            roleRepository.save(superAdminRole);
        }
    }

    // String[] permAgent = {
    //     "get_dep_by_emp", "list_dep", "add_dep", "delete_dep", "list_emp", "add_emp", "update_emp", "delete_emp"
    // };

    // @Transactional
    // public void createAgentRole() {
    //     String agentRoleName = "agent";
    //     Role agentRole = roleRepository.findByName(agentRoleName);

    //     // Créez le rôle "agent" s'il n'existe pas
    //     if (agentRole == null) {
    //         agentRole = new Role();
    //         agentRole.setName(agentRoleName);
    //         List<Permission> prList = new ArrayList<>();
    //         for (String perm : permAgent) {
    //             Permission permission = permissionRepository.findByName(perm);
    //             if (permission != null) {
    //                 prList.add(permission);
    //             }
    //         }
    //         agentRole.setPermissions(prList);
    //         roleRepository.save(agentRole);
    //     }
    // }



}