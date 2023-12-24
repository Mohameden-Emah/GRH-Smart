package com.grh.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.grh.dao.AppUserRepo;
import com.grh.dao.RoleRepo;
import com.grh.entity.AppUser;
import com.grh.entity.Role;
import com.grh.service.UserServices;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private AppUserRepo appUserRepository;

    @Autowired
    private RoleRepo roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public ResponseEntity<?> addUser(AppUser userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        Role roleUse = roleRepository.findById(1).get();
        userInfo.setRole(roleUse);
        appUserRepository.save(userInfo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public AppUser fidUserByUsername(String username) {
        return appUserRepository.findByUsername(username).get();
    }

    @Override
    public void DeleteUser(Integer id) {
        appUserRepository.deleteById(id);
    }

    @Override
    public boolean findUserById(Integer id) {
        if (appUserRepository.findById(id).isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }

    public AppUser getUserById(Integer id) {
        if (appUserRepository.findById(id).isPresent()) {
            return appUserRepository.findById(id).get();
        }
        return null;
    }
}