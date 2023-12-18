package com.grh.service.employeBydep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResult {
    private List<EmployeeByDepartment> departmentsByEmployees;
}
