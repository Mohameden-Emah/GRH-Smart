package com.grh.service;


import com.grh.entites.Departement;

import com.grh.reposetory.DepartementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepo repository;
    public Departement createDepartement (Departement departement){
        return repository.save(departement);
    }


    public Boolean deleteDepartement(Long id) {
        Optional<Departement> DepartementOptional = repository.findById(id);
        if(DepartementOptional.isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Departement> finAllDepartement(){
        return repository.findAll();
    }






}
