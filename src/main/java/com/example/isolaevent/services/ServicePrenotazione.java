package com.example.isolaevent.services;

import com.example.isolaevent.repositories.RepoCRUDPrenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServicePrenotazione {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private RepoCRUDPrenotazione prenRepo;

    public ServicePrenotazione(RepoCRUDPrenotazione prenRepo){
        this.prenRepo = prenRepo;
    }

    public boolean creaPrenotazione(UUID idUtente, UUID idEvento){
        return prenRepo.creaPrenotazione(idUtente,idEvento);
    }

    public List<UUID> getPrenotazioniPassate(UUID idUtente){
        return prenRepo.getPrenotazioniPassate(idUtente);
    }

    public List<UUID> getPrenotazioniFuture(UUID idUtente){
        return prenRepo.getPrenotazioniFuture(idUtente);
    }
}
