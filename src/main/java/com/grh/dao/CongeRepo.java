package com.grh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grh.entity.Conge;
import com.grh.entity.Employee;


public interface CongeRepo extends JpaRepository<Conge,Long> {
    List<Conge> findByEmployee(Employee employee);

}
