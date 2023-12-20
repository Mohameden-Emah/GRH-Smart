package com.grh.service;


import com.grh.entites.Departement;

import com.grh.reposetory.DepartementRepo;
import com.grh.service.employeBydep.DepEmployees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementService implements DepartementServiceln {

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


    @Override
    public DepEmployees getDepEmp(Long id) {
        Optional<Departement> dep = repository.findById(id);
        if(dep.isPresent()){

            
            
        }
    }

    






}
