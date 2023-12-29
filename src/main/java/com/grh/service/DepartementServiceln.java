package com.grh.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.grh.entity.Departement;

public interface DepartementServiceln {
    public Departement  createDepartement(Departement departement);
    public List<Departement> finAllDepartement();
    public Boolean deleteDepartement(Long id);
    public ResponseEntity<Object> getDepEmp(Long id);

}
