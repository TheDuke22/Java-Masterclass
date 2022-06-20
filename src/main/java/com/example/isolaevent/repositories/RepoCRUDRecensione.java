package com.example.isolaevent.repositories;

import com.example.isolaevent.models.Recensione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public class RepoCRUDRecensione {

    private List<UUID> checkUtenteByPren(UUID idPren) {  //cercando l'utente tramite la prenotazione che ha fatto posso inserire esso nella recensione
        //ogni prenotazione è rivolta a un solo utente, per cui sarà univoca per ognuno
        String sql = "select p.idutente from schema_isolaevent.prenota as p where p.idprenotazione = ?";
        return jdbcTemplate.queryForList(sql, UUID.class, idPren);
    }

    private List<UUID> checkOrganizzatore(UUID idPren) {  //prendo l'organizzatore di un evento
        String sql = "select e.idorganizzatore from schema_isolaevent.prenota as p, schema_isolaevent.evento as e where p.idevento = e.id and p.idprenotazione = ?";
        return jdbcTemplate.queryForList(sql, UUID.class, idPren);
    }

    private boolean isFinished(UUID idPren) {    //dall'idprenotazione, faccio la join con la tabella evento e vedo se è finito
        LocalDateTime time = LocalDateTime.now();
        String sql = "select p.idprenotazione from schema_isolaevent.prenota as p, schema_isolaevent.evento as e where e.id = p.idevento and p.idprenotazione = ? and e.data_ora_fine < ?";
        List<UUID> eventoNonfinito = jdbcTemplate.queryForList(sql, UUID.class, idPren, time);
        return !eventoNonfinito.isEmpty();
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean creaRecensione(String titolo, String descrizione, int valutazione, UUID prenotazione) {
        //controllare nel service che l'vento sia finito e inoltre devo controllare se la prenotazione esiste in "Prenota"
        // posso prendere l'organizzatore da evento, tale entità infatti contiene la chiave esterna di utente che rappresenta appunto l'organizzatore
        List<UUID> u = checkUtenteByPren(prenotazione);
        UUID idutente = u.get(0);
        List<UUID> o = checkOrganizzatore(prenotazione);
        UUID idorganizzatore = o.get(0);

        if (isFinished(prenotazione)) return false;

        String query = "insert into schema_isolaevent.recensione(titolo,descrizione,valutazione,idutente,idorganizzatore) values (?,?,?,?,?)";
        int val = jdbcTemplate.update(query, titolo, descrizione, valutazione, idutente, idorganizzatore);
        return val > 0;
    }

}
