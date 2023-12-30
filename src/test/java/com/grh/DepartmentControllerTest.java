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

import com.grh.dto.DepEmployees;
import com.grh.entity.Departement;
import com.grh.entity.Employee;
import com.grh.service.serviceImpl.DepartementService;
import com.grh.web.DepartementController;

class DepartmentControllerTest {

    @InjectMocks
    private DepartementController departementController;

    @Mock
    private DepartementService departementService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateDepartement() {
        Departement departement = new Departement();
        when(departementService.createDepartement(departement)).thenReturn(departement);

        ResponseEntity<Departement> responseEntity = departementController.createDepartement(departement);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(departement, responseEntity.getBody());
    }

    @Test
    void testAllDepartement() {
        List<Departement> departementList = Arrays.asList(new Departement(), new Departement());
        when(departementService.finAllDepartement()).thenReturn(departementList);

        ResponseEntity<List<Departement>> responseEntity = departementController.allDepartement();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(departementList, responseEntity.getBody());
    }

    @Test
    void testDeleteDepartementByID() {
        Long departementId = 1L;
        when(departementService.deleteDepartement(departementId)).thenReturn(true);

        ResponseEntity<Boolean> responseEntity = departementController.deleteDepartementByID(departementId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(true, responseEntity.getBody());
    }

    @Test
    void testGetDepEmps() {
        Long departementId = 1L;
        DepEmployees depEmployees = new DepEmployees(2, Arrays.asList(new Employee(), new Employee()));
        when(departementService.getDepEmp(departementId)).thenReturn(ResponseEntity.ok().body(depEmployees));

        ResponseEntity<Object> responseEntity = departementController.getDepEmps(departementId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(depEmployees, responseEntity.getBody());
    }
}
