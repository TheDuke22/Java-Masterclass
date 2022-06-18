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

    private Float searchUtente(UUID idUtente) {
        String sql = "select u.portafoglio from schema_isolaevent.utente as u where u.id = ?";
        return  jdbcTemplate.queryForObject(sql,Float.class,idUtente);
    }

    private Float searchEvento(UUID idEvento) {
        String sql = "select e.prezzo from schema_isolaevent.evento as e where e.id = ?";
        return  jdbcTemplate.queryForObject(sql,Float.class,idEvento);
    }

    public boolean creaPrenotazione(UUID idUtente, UUID idEvento){
        Float portafoglio = searchUtente(idUtente);
        Float prezzoEvento = searchEvento(idEvento);
        if(portafoglio >= prezzoEvento){
            portafoglio = portafoglio-prezzoEvento;
            String setPortaglio = "update schema_isolaevent.utente set portafoglio = ? where id = ?";
            jdbcTemplate.update(setPortaglio,portafoglio,idUtente);
            String query = "insert into schema_isolaevent.prenota(idutente,idevento) values (?,?)";
            int value = jdbcTemplate.update(query,idUtente,idEvento);
            return value > 0;
        }
        System.out.println("Saldo Insufficiente");
        return false;
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
