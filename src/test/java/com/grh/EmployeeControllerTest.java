package com.grh;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.grh.entity.Employee;
import com.grh.service.serviceImpl.EmployeeService;
import com.grh.web.EmployeeController;

class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAllEmployee() {
        List<Employee> employeeList = Arrays.asList(new Employee(), new Employee());
        when(employeeService.finAllEmp()).thenReturn(employeeList);

        ResponseEntity<List<Employee>> responseEntity = employeeController.allEmployee();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employeeList, responseEntity.getBody());
    }

    @Test
    void testById() {
        Long employeeId = 1L;
        when(employeeService.getEmployeeByID(employeeId)).thenReturn(true);

        ResponseEntity<Boolean> responseEntity = employeeController.byId(employeeId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(true, responseEntity.getBody());
    }

    @Test
    void testCreateEmployee() {
        Employee employee = new Employee();
        when(employeeService.createEmp(employee)).thenReturn(employee);

        ResponseEntity<Employee> responseEntity = employeeController.createEmployee(employee);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(employee, responseEntity.getBody());
    }

    @Test
    void testDeleteEmployeeByID() {
        Long employeeId = 1L;
        when(employeeService.deleteEmp(employeeId)).thenReturn(true);

        ResponseEntity<Boolean> responseEntity = employeeController.deleteEmployeeByID(employeeId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(true, responseEntity.getBody());
    }

    @Test
    void testUpdateEmployee() {
        Long employeeId = 1L;
        Employee employee = new Employee();
        when(employeeService.updateEmp(employee, employeeId)).thenReturn("Employee est modified");

        ResponseEntity<String> responseEntity = employeeController.deleteEmployeeByID(employee, employeeId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Employee est modified", responseEntity.getBody());
    }
}
