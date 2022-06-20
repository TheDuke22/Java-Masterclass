package com.example.isolaevent.repositories;

import com.example.isolaevent.models.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class RepoCRUDEvento {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //da rivedere e controllare e testare
    //creare un evento
    public boolean createEvent(Evento evento){

        //controlla se ci sono collisioni di orari
        String sql="select count(*) from schema_isolaevent.evento e where ((e.data_ora_inizio<=? and e.data_ora_fine>=?) " +
                "or (e.data_ora_inizio<=?  and e.data_ora_fine>=?) or (e.data_ora_inizio>? and e.data_ora_fine<?)) and e.idstanza=?";

        int collisioneEvento=jdbcTemplate.queryForObject(sql,Integer.class,evento.getDataOraInizio(),evento.getDataOraInizio(),evento.getDataOraFine(),evento.getDataOraFine(),evento.getDataOraInizio(),evento.getDataOraFine(),evento.getIdStanza());


        //esci se c'è una collisione
        if(collisioneEvento>0){
            System.out.println("c'e' collisione di eventi");
            return false;
        }

        //superati i controlli posso inserire
        int value = jdbcTemplate.update("insert into schema_isolaevent.evento(titolo, descrizione, prezzo, idstanza, idorganizzatore, data_ora_inizio, data_ora_fine) values (?,?,?,?,?,?,?)",
                evento.getTitolo(),evento.getDescrizione(),evento.getPrezzo(),evento.getIdStanza(),evento.getIdOrganizzatore(),evento.getDataOraInizio(),evento.getDataOraFine());

        return value > 0;
    }

    //ottenere un certo evento dato un id
    public Evento getEvento (UUID id){
        String sql = "select * from schema_isolaevent.evento where id = ?;";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Evento.class), id);
    }

    //select di tutti gli eventi solo se posti disponibili >0
    public Evento getAvailableEvent(UUID id){

        //conta i posti occupati rispetto ad un evento
        String sql="select count(*) from schema_isolaevent.prenota p where p.idevento=?";

        int postiOccupati=jdbcTemplate.queryForObject(sql,Integer.class,id);

        //conta la capienza
        String sql_two="select s.capienza from schema_isolaevent.evento e, schema_isolaevent.stanza s where e.idstanza=s.id and e.id=?";

        int capienza=jdbcTemplate.queryForObject(sql_two,Integer.class,id);

        if(postiOccupati>=capienza){
            System.out.println("Non ci sono piu' posti per quest'evento");
            return null;
        }

        String solution="select e.* from schema_isolaevent.evento e where e.id=?";
        Evento e=jdbcTemplate.queryForObject(solution,new BeanPropertyRowMapper<>(Evento.class),id);

        if(e.getDataOraInizio().isAfter(LocalDateTime.now())){
            return e;
        }
        System.out.println("L'evento non piu' disponibile perchè è gia' passato");
        return null;
    }

    public List<Evento> getAllEvents(){   // Tutti gli eventi disponibili
        List<UUID> eventi;
        String sql="select e.id from schema_isolaevent.evento e where true";

        eventi=jdbcTemplate.queryForList(sql,UUID.class);
        if(eventi.isEmpty()) return null;

        List<Evento> solution=new ArrayList<>();
        for(UUID e:eventi){
            Evento eve;
            if((eve=getAvailableEvent(e))!=null){
                solution.add(eve);
            }
        }
        return solution;
    }
}
