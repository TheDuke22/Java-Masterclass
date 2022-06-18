package com.example.isolaevent.repositories;

import com.example.isolaevent.models.Stanza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class RepoCRUDStanza {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean createStanza (Stanza stanza){
        int value = jdbcTemplate.update("insert into schema_isolaevent.stanza(nome, capienza) values (?,?)",
                stanza.getNome(),stanza.getCapienza());
        return value > 0;
    }


    public Stanza getStanza (UUID id){
        String sql = "select * from schema_isolaevent.stanza where id = ?;";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Stanza.class), id);
    }


    public boolean updateStanza (Stanza stanza){
        int value = jdbcTemplate.update("update schema_isolaevent.stanza set nome=?,capienza=? where id =?",
                stanza.getNome(), stanza.getCapienza());
        return value > 0;
    }


    public boolean deleteStanza(UUID id){
        String sql = "delete from schema_isolaevent.stanza where id = ?";
        return jdbcTemplate.update(sql, id) >0;
    }



}
