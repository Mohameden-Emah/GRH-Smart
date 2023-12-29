package com.grh;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.grh.dao.EmployeeRepo;
import com.grh.entity.Employee;
import com.grh.service.serviceImpl.EmployeeService;

@SpringBootTest
class EmployeeServiceTest {

    @Mock
    private EmployeeRepo repository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void testCreateEmp() {
        Employee employee = new Employee();
        when(repository.save(any(Employee.class))).thenReturn(employee);

        Employee result = employeeService.createEmp(employee);

        assertNotNull(result);
        verify(repository, times(1)).save(any(Employee.class));
    }

    @Test
    void testDeleteEmp() {
        Long employeeId = 1L;
        when(repository.findById(employeeId)).thenReturn(Optional.of(new Employee()));

        boolean result = employeeService.deleteEmp(employeeId);

        assertTrue(result);
        verify(repository, times(1)).deleteById(employeeId);
    }

    @Test
    void testDeleteEmp_NotFound() {
        Long employeeId = 1L;
        when(repository.findById(employeeId)).thenReturn(Optional.empty());

        boolean result = employeeService.deleteEmp(employeeId);

        assertFalse(result);
        verify(repository, never()).deleteById(anyLong());
    }

    @Test
    void testFinAllEmp() {
        List<Employee> employees = Arrays.asList(new Employee(), new Employee());
        when(repository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.finAllEmp();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    // Similar tests for updateEmp and getEmployeeByID methods

    // ...

}