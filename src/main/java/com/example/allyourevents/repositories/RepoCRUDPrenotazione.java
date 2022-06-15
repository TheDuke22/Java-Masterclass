package com.example.allyourevents.repositories;
/*
Prenotazione o Crea prenotazione per un evento (passaggio di utente ed evento come parametri) oppure
Ottenere tutte le prenotazioni passate dato un utente o Ottenere tutte le prenotazioni future dato un utente
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public class RepoCRUDPrenotazione {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean creaPrenotazione(UUID idUtente, UUID idEvento){
        String query = "insert into schema_isolaevent.prenota(idutente,idevento) values (?,?)";
        int value = jdbcTemplate.update(query,idUtente,idEvento);
        return value > 0;
    }

    public List<UUID> getPrenotazioniPassate(UUID idUtente){
        LocalDateTime data = LocalDateTime.now();
        String query = "select p.idprenotazione from schema_isolaevent.prenota as p, schema_isolaevent.evento as e where e.id = p.idevento and e.data_ora_inizio < ? and p.idutente = ?";
        return jdbcTemplate.queryForList(query,UUID.class,data,idUtente);
    }

    public List<UUID> getPrenotazioniFuture(UUID idUtente){
        LocalDateTime data = LocalDateTime.now();
        String query = "select p.idprenotazione from schema_isolaevent.prenota as p, schema_isolaevent.evento as e where e.id = p.idevento and e.data_ora_inizio > ? and p.idutente = ?";
        return jdbcTemplate.queryForList(query,UUID.class,data,idUtente);
    }
}
