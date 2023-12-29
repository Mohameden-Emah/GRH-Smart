package com.grh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grh.entity.Departement;
import com.grh.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    public List<Employee> findByDepartement(Departement departement);

}
