package com.grh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grh.entites.Role;
import com.grh.service.RoleService;

@RestController
@RequestMapping("api/role")
public class RoleController {

      @Autowired
    private RoleService service;
    
    @GetMapping("/all")
    public ResponseEntity<List<Role>> allRole(){
        return ResponseEntity.status(HttpStatus.OK).body(service.finAllRole());
    }

    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody Role Role ){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createRole(Role));
    }
    

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteRoleByID(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteRole(id));
    }


    
}
