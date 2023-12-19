package com.grh.reposetory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grh.entites.Conge;
import com.grh.entites.Employee;


public interface CongeRepo extends JpaRepository<Conge,Long> {
    List<Conge> findByEmployee(Employee employee);

}
