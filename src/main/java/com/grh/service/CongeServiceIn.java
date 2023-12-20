package com.grh.service;

import java.util.List;

import com.grh.entites.Conge;
import com.grh.entites.Employee;

public interface CongeServiceIn {
    public String createConge(Conge conge);
    public List<Conge> finAllConge();
    public String updateConge(Conge conge, Long id);
    public Boolean deleteConge(Long id);
    public boolean checkCongeThisYear(Employee employee);

}
