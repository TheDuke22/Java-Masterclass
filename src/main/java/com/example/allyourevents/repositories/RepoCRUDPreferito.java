package com.example.allyourevents.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class RepoCRUDPreferito {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean inserisciPreferito(UUID idUtente, UUID idEvento){
        String query = "insert into schema_isolaevent.prenota(idutente,idevento) values (?,?)";
        int val = jdbcTemplate.update(query,idUtente,idEvento);
        return val > 0;
    }

    public boolean removePreferito(UUID idUtente, UUID idEvento){
        String query = "delete from schema_isolaevent.prenota as p where p.idutente = ? and p.idevento = ?";
        int val = jdbcTemplate.update(query,idUtente,idEvento);
        return val >0;
    }

    //ritornare tutti gli eventi a cui partecipa un utente dato in input
    public List<UUID> getPreferiti(UUID idUtente){
        String query = "select p.idevento from schema_isolaevent.prenota as p where p.idutente = ?";
        return jdbcTemplate.queryForList(query,UUID.class,idUtente);
    }
}
