package com.grh.service;

import java.util.List;

import com.grh.entity.Employee;

public interface EmployeServiceIn {
    public Employee createEmp(Employee employee);
    public Boolean deleteEmp(Long id);
    public List<Employee> finAllEmp();
    public String updateEmp(Employee employee, Long id);
    public boolean getEmployeeByID(Long id);
}
