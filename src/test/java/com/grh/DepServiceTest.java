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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.grh.dao.DepartementRepo;
import com.grh.dao.EmployeeRepo;
import com.grh.dto.DepEmployees;
import com.grh.entity.Departement;
import com.grh.entity.Employee;
import com.grh.service.serviceImpl.DepartementService;

@SpringBootTest
class DepServiceTest {

    @Mock
    private DepartementRepo departementRepo;

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private DepartementService departementService;

    @Test
    void testGetDepartementEmployees() {
        // Arrange
        Long departementId = 1L;

        // Créer un sample Departement et une liste d'Employee
        Departement departement = new Departement();
        departement.setIdDep(departementId);

        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setDepartement(departement);

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setDepartement(departement);

        List<Employee> departementEmployees = Arrays.asList(employee1, employee2);

        // Configurer le comportement des mocks
        when(departementRepo.findById(departementId)).thenReturn(Optional.of(departement));
        when(employeeRepo.findByDepartement(departement)).thenReturn(departementEmployees);

        // Act
        ResponseEntity<Object> response = departementService.getDepEmp(departementId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Vérifier le type de la réponse
        assertTrue(response.getBody() instanceof DepEmployees);

        // Cast de la réponse au type attendu
        DepEmployees depEmployees = (DepEmployees) response.getBody();

        // Vérifier la correspondance des données
        assertEquals(departementEmployees.size(), depEmployees.getTotal());
        assertEquals(departementEmployees, depEmployees.getEmp());

        // Vérifier que les méthodes des repos ont été appelées avec les bons paramètres
        verify(departementRepo, times(1)).findById(departementId);
        verify(employeeRepo, times(1)).findByDepartement(departement);
    }

    @Test
    void testCreateDepartement() {
        Departement departement = new Departement();
        when(departementRepo.save(any(Departement.class))).thenReturn(departement);

        Departement result = departementService.createDepartement(departement);

        assertNotNull(result);
        verify(departementRepo, times(1)).save(any(Departement.class));
    }

    @Test
    void testDeleteDepartement() {
        Long departementId = 1L;
        when(departementRepo.findById(departementId)).thenReturn(Optional.of(new Departement()));

        boolean result = departementService.deleteDepartement(departementId);

        assertTrue(result);
        verify(departementRepo, times(1)).deleteById(departementId);
    }

    @Test
    void testDeleteDepartement_NotFound() {
        Long departementId = 1L;
        when(departementRepo.findById(departementId)).thenReturn(Optional.empty());

        boolean result = departementService.deleteDepartement(departementId);

        assertFalse(result);
        verify(departementRepo, never()).deleteById(anyLong());
    }

    @Test
    void testFinAllDepartement() {
        List<Departement> departements = Arrays.asList(new Departement(), new Departement());
        when(departementRepo.findAll()).thenReturn(departements);

        List<Departement> result = departementService.finAllDepartement();

        assertEquals(2, result.size());
        verify(departementRepo, times(1)).findAll();
    }

}