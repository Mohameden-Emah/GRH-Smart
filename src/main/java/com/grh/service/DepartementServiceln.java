package com.grh.service;

import java.util.List;

import com.grh.entites.Departement;
import com.grh.service.employeBydep.DepEmployees;

public interface DepartementServiceln {
    public Departement  createDepartement(Departement departement);
    public List<Departement> finAllDepartement();
    public Boolean deleteDepartement(Long id);
    public DepEmployees getDepEmp(Long id);

}
