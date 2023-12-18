package com.grh.service;

import com.grh.entites.Employee;
import com.grh.service.employeBydep.EmployeeResult;

import java.util.List;

public interface EmployeServiceIn {
    public Employee createEmp(Employee Employee);
    public Boolean deleteEmp(Long id);
    public List<Employee> finAllEmp();
    public String updateEmp(Employee Employee, Long id);
    public EmployeeResult getEmployeeByDep();
}
