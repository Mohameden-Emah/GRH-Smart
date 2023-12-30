package com.grh;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.grh.dao.CongeRepo;
import com.grh.dao.EmployeeRepo;
import com.grh.entity.Conge;
import com.grh.entity.Employee;
import com.grh.service.serviceImpl.CongeService;

class CongeServiceTest {

    @InjectMocks
    private CongeService congeService;

    @Mock
    private CongeRepo congeRepo;

    @Mock
    private EmployeeRepo employeeRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateConge() {
        Conge conge = new Conge();
        conge.setEmployee(new Employee()); // Set required fields

        when(congeRepo.save(conge)).thenReturn(conge);

        String result = congeService.createConge(conge);

        assertEquals("Passed", result);
        verify(congeRepo, times(1)).save(conge);
    }


    @Test
    void testDeleteConge() {
        Long congeId = 1L;

        when(congeRepo.findById(congeId)).thenReturn(Optional.of(new Conge()));

        Boolean result = congeService.deleteConge(congeId);

        assertTrue(result);
        verify(congeRepo, times(1)).deleteById(congeId);
    }

    @Test
    void testDeleteCongeNotFound() {
        Long congeId = 1L;

        when(congeRepo.findById(congeId)).thenReturn(Optional.empty());

        Boolean result = congeService.deleteConge(congeId);

        assertFalse(result);
        verify(congeRepo, never()).deleteById(any());
    }

    // Add more test cases as needed
}