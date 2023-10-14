package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Universite;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UniversiteServiceTest {
    @Autowired
    private UniversiteService universiteService;
    @Test
    public void shouldSaveUniversiteWithSuccess(){
       Universite expectedUniversite= Universite.builder()
                .nomUniversite("ESPRIT TEST")
                .build();
       Universite savedUniversite=universiteService.addUnversite(expectedUniversite);
       assertNotNull(savedUniversite);
       assertEquals(expectedUniversite.getNomUniversite(),savedUniversite.getNomUniversite());
    }
}