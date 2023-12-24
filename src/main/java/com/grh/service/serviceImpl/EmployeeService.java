package com.grh.service.serviceImpl;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.grh.dao.EmployeeRepo;
import com.grh.entity.Employee;
import com.grh.service.EmployeServiceIn;

@Service
public class EmployeeService implements EmployeServiceIn{
    
    @Autowired
    private EmployeeRepo repository;


    public Employee createEmp(Employee employee){
        return repository.save(employee);
    }

    @Override
    public Boolean deleteEmp(Long id) {
        Optional<Employee> employeeOptional = repository.findById(id);
        if(employeeOptional.isPresent()){
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

    // @Override
    // public EmployeeResult getEmployeeByDep() {
    //     List<Employee> employees = repository.findAll();
    //     List<Departement> departments = departementRepo.findAll();

    //     List<EmployeeByDepartment> departmentsByEmployees = new ArrayList<>();

    //     for (Departement department : departments) {
    //         List<Employee> employeesInDepartment = new ArrayList<>();
    //         for (Employee employee : employees) {
    //             if (employee.getDepartement().equals(department)) {
    //                 employeesInDepartment.add(employee);
    //             }
    //         }

    //         EmployeeByDepartment departmentWithEmployees = new EmployeeByDepartment();
    //         departmentWithEmployees.setDepartmentName(department.getName_dep());
    //         departmentWithEmployees.setTotalEmployees(employeesInDepartment.size());

    //         List<String> employeeNames = employeesInDepartment.stream()
    //                 .map(Employee::getName)
    //                 .collect(Collectors.toList());

    //         departmentWithEmployees.setEmployeeNames(employeeNames);

    //         departmentsByEmployees.add(departmentWithEmployees);
    //     }

    //     EmployeeResult employeeResult = new EmployeeResult();
    //     employeeResult.setDepartmentsByEmployees(departmentsByEmployees);

    //     return employeeResult;
    // }

    @Override
    public boolean getEmployeeByID(Long id) {
        Optional<Employee> existingEmployeeOptional = repository.findById(id);
        
        if(existingEmployeeOptional.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

}
