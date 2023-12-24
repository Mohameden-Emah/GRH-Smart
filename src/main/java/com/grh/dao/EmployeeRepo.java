package com.grh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grh.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
