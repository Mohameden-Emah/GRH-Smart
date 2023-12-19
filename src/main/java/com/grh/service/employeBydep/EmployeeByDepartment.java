package com.grh.service.employeBydep;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeByDepartment {
    private String departmentName;
    private int totalEmployees;
    private List<String> employeeNames;
}










