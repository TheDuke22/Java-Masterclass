package com.example.isolaevent.services;

import com.example.isolaevent.repositories.RepoCRUDRecensione;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ServiceRecensione {
    private RepoCRUDRecensione repoRec;

    public ServiceRecensione(RepoCRUDRecensione repoRec){
        this.repoRec = repoRec;
    }

    public boolean creaRecensione(String titolo, String descrizione, int valutazione, UUID prenotazione){
        return repoRec.creaRecensione(titolo,descrizione,valutazione,prenotazione);
    }
}
