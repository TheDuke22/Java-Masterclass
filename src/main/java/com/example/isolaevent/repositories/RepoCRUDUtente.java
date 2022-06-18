package com.example.isolaevent.repositories;

import com.example.isolaevent.models.Evento;
import com.example.isolaevent.models.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RepoCRUDUtente {

    private List<Evento> getFullEvento(List<UUID> eventi){
        String query = "select e.* from schema_isolaevent.evento as e where e.id = ?";
        List<Evento> e = new ArrayList<>();
        for (UUID uuid : eventi) {
            e.add( jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Evento.class), uuid));
        }
        return e;
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
    List<Evento> eventiCreati = new ArrayList<>();

    public boolean createUtente (Utente utente){
       int value = jdbcTemplate.update("insert into schema_isolaevent.utente(nome, cognome, email, datadinascita, portafoglio ) values (?,?,?,?,?)",
                utente.getNome(),utente.getCognome(),utente.getEmail(),utente.getDataDiNascita(),utente.getPortafoglio());
       return value > 0;
    }

    public Utente getUtente (UUID id){
        String sql = "select * from schema_isolaevent.utente where id = ?;";
       return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Utente.class), id);
    }

    public boolean updateUtente (Utente utente){
        int value = jdbcTemplate.update("update schema_isolaevent.utente set nome=?,cognome=?,email=?,datadinascita=?,portafoglio=? where id =?",
                utente.getNome(),utente.getCognome(),utente.getEmail(),utente.getDataDiNascita(),utente.getPortafoglio(), utente.getId());
        return value > 0;
    }

    public boolean deleteUtente(UUID id){
        String sql = "delete from schema_isolaevent.utente where id = ?";
        return jdbcTemplate.update(sql, id) >0;
    }

    public List<Evento> getOrganizzati(UUID idOrganizzatore){   //id appartenente all'entità utente
        String query = "select e.id from schema_isolaevent.evento as e where e.idorganizzatore = ?";
        return getFullEvento(jdbcTemplate.queryForList(query,UUID.class,idOrganizzatore));
    }
}
