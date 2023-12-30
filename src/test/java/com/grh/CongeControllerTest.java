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

import com.grh.entity.Conge;
import com.grh.service.serviceImpl.CongeService;
import com.grh.web.CongeController;

class CongeControllerTest {

    @InjectMocks
    private CongeController congeController;

    @Mock
    private CongeService congeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAllConge() {
        List<Conge> congeList = Arrays.asList(new Conge(), new Conge());
        when(congeService.finAllConge()).thenReturn(congeList);

        ResponseEntity<List<Conge>> responseEntity = congeController.allConge();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(congeList, responseEntity.getBody());
    }

    @Test
    void testCreateConge() {
        Conge conge = new Conge();
        when(congeService.createConge(conge)).thenReturn("Passed");

        ResponseEntity<String> responseEntity = congeController.createConge(conge);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Passed", responseEntity.getBody());
    }

    @Test
    void testDeleteCongeByID() {
        Long congeId = 1L;
        when(congeService.deleteConge(congeId)).thenReturn(true);

        ResponseEntity<Boolean> responseEntity = congeController.deleteCongeByID(congeId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(true, responseEntity.getBody());
    }

    // Add more test cases as needed
}
