package com.grh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.grh.entites.Departement;
import com.grh.reposetory.DepartementRepo;
import com.grh.service.employeBydep.EmployeeByDepartment;
import com.grh.service.employeBydep.EmployeeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grh.entites.Employee;
import com.grh.reposetory.EmployeeRepo;

@Service
public class EmployeeService implements EmployeServiceIn{
    
    @Autowired
    private EmployeeRepo repository;
    @Autowired
    private DepartementRepo departementRepo;

    public Employee createEmp(Employee Employee){
        return repository.save(Employee);
    }

    @Override
    public Boolean deleteEmp(Long id) {
        Optional<Employee> EmployeeOptional = repository.findById(id);
        if(EmployeeOptional.isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }



    public List<Employee> finAllEmp(){
        return repository.findAll();
    }

    @Override
    public String updateEmp(Employee updatedEmployee, Long id) {
        Optional<Employee> existingEmployeeOptional = repository.findById(id);
    
        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.setName(updatedEmployee.getName());
            
    
            repository.save(existingEmployee);
            
            return "Employee est modified";
        } else {
            return "Employee not exist";
        }
    }

    @Override
    public EmployeeResult getEmployeeByDep() {
        List<Employee> employees = repository.findAll();
        List<Departement> departments = departementRepo.findAll();

        List<EmployeeByDepartment> departmentsByEmployees = new ArrayList<>();

        for (Departement department : departments) {
            List<Employee> employeesInDepartment = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getDepartement().equals(department)) {
                    employeesInDepartment.add(employee);
                }
            }

            EmployeeByDepartment departmentWithEmployees = new EmployeeByDepartment();
            departmentWithEmployees.setDepartmentName(department.getName_dep());
            departmentWithEmployees.setTotalEmployees(employeesInDepartment.size());

            List<String> employeeNames = employeesInDepartment.stream()
                    .map(Employee::getName)
                    .collect(Collectors.toList());

            departmentWithEmployees.setEmployeeNames(employeeNames);

            departmentsByEmployees.add(departmentWithEmployees);
        }

        EmployeeResult employeeResult = new EmployeeResult();
        employeeResult.setDepartmentsByEmployees(departmentsByEmployees);

        return employeeResult;
    }

}
