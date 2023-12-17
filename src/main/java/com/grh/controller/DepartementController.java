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

import com.grh.entites.Departement;
import com.grh.service.DepartementService;

@RestController
@RequestMapping("/api/dep")
public class DepartementController {

    @Autowired
    private DepartementService service;

    @PostMapping("create")
    public ResponseEntity<Departement>createDepartement(@RequestBody Departement departement){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createDepartement(departement));
    }


    @GetMapping("all")
    public ResponseEntity<List<Departement>> allDepartement(){
        return ResponseEntity.status(HttpStatus.OK).body(service.finAllDepartement());
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteDepartementByID(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service. deleteDepartement(id));
    }

}
