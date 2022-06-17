package com.example.allyourevents.repositories;

import com.example.allyourevents.models.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class EventsCrudRepo {

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

    //da rivedere e controllare e testare
    //creare un evento
    public boolean createEvent(Evento evento) {
        String sql = "select count(*) from schema_isolaevent.evento as e where (e.idstanza=? and ((? < e.data_ora_inizio and ? < e.data_ora_inizio) or (? > e.data_ora_fine and ? > e.data_ora_fine)))";

        int collisioneEvento= 0;
        collisioneEvento = jdbcTemplate.queryForObject(sql, Integer.class, evento.getIdStanza(), evento.getDataOraInizio(), evento.getDataOraFine(), evento.getDataOraInizio(), evento.getDataOraFine());

        //esci se c'è una collisione
        if (collisioneEvento > 0) {


            //superati i controlli posso inserire
            int value = jdbcTemplate.update("insert into schema_isolaevent.evento(titolo, descrizione, prezzo, idstanza, idorganizzatore, data_ora_inizio, data_ora_fine) values (?,?,?,?,?,?,?)",
                    evento.getTitolo(), evento.getDescrizione(), evento.getPrezzo(), evento.getIdStanza(), evento.getIdOrganizzatore(), evento.getDataOraInizio(), evento.getDataOraFine());


            return value > 0;
        } else
            return false;
    }




        //controlla se ci sono collisioni di orari
        //String sql = "select count(*) from schema_isolaevent.evento as e where (e.idstanza=? and ((? < e.data_ora_inizio and ? < e.data_ora_inizio) or (? > e.data_ora_fine and ? > e.data_ora_fine)))";
       //String sql="select count(*) from schema_isolaevent.evento as e where (e.idstanza=? and ((e.data_ora_inizio and ?>=e.data_ora_fine) or (?<=e.data_ora_inizio  and ?>=e.data_ora_fine)))";

        //int collisioneEvento=jdbcTemplate.queryForObject(sql,Integer.class,evento.getIdStanza(),evento.getDataOraInizio(),evento.getDataOraInizio(),evento.getDataOraFine(),evento.getDataOraFine());


    //ottenere un certo evento dato un id
    public Evento getEvento (UUID id){
        String sql = "select * from schema_isolaevent.evento where id = ?;";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Evento.class), id);
    }

    //select di tutti gli eventi solo se posti disponibili >0
    public List<Evento> getAllEvents(UUID id){
        //conta i posti disponibili rispetto ad un evento
        String sql="select count id=? from schema_isolaevent.prenotazione";
        int number=jdbcTemplate.queryForObject(sql,Integer.class,id);

        /*
        String sql ="select e.id from schema_isolaevent.evento e,schema_isolaevent.stanza s where s.id=e.idstanza and s.postidisponibili>0";
        return getFullEvento(jdbcTemplate.queryForList(sql,UUID.class));
        */
        return null;
    }


}
