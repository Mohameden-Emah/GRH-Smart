package com.grh.service;

import com.grh.entites.Departement;

import java.util.List;

public interface DepartementServiceln {
    public Departement  createDepartement(Departement departement);
    public List<Departement> finAllDepartement();
    public Boolean deleteDepartement(Long id);

}
