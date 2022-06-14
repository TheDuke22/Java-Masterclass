package com.example.allyourevents.repositories;

import com.example.allyourevents.models.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class RepoCRUDUtente {

    @Autowired
    JdbcTemplate jdbcTemplate;
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

}
