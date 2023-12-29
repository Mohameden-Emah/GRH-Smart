package com.grh.dto;

import java.util.List;

import com.grh.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepEmployees {
    private int total;
    private List<Employee> emp;
}
