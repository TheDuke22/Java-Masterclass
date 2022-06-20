package com.example.isolaevent;

import com.example.isolaevent.models.Utente;
import com.example.isolaevent.repositories.RepoCRUDUtente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class IsolaEventApplicationTests {
    @Autowired
    RepoCRUDUtente utenteRepository;


    Utente u1;


    @Test
    public void testCreateUser(){
        u1=new Utente("Dino","Lanza","dinolanza@fame.it",new GregorianCalendar(1992, Calendar.OCTOBER,27).getTime(),17.5f);
        boolean value=utenteRepository.createUtente(u1);

        assertEquals(true,value);
    }

}
