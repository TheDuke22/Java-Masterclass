package com.example.allyourevents.controller;

import com.example.allyourevents.models.Evento;
import com.example.allyourevents.models.Prenota;
import com.example.allyourevents.models.Utente;
import com.example.allyourevents.repositories.RepoCRUDUtente;
import com.example.allyourevents.services.CrudService;
import com.example.allyourevents.services.ServicePrenotazione;
import com.example.allyourevents.services.ServiceRecensione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping (value = "/isolaEvent")
public class IsolaController {
    @Autowired
    CrudService service;
    @Autowired
    ServicePrenotazione servicePren;
    @Autowired
    ServiceRecensione serviceRec;

    public IsolaController(CrudService service, ServicePrenotazione servicePren, ServiceRecensione serviceRec) {
        this.service = service;
        this.servicePren = servicePren;
        this.serviceRec = serviceRec;
    }

    @PostMapping (value = "/createUtente")
    public ResponseEntity <Void> createUtente (@RequestBody Utente utente){
        boolean isCreated = service.createUtente(utente);
        if (isCreated) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @GetMapping (value = "/getUtente")
    public ResponseEntity <Utente> getUtente (@RequestParam (value = "id")UUID id ){

        Utente utente= service.getUtente(id);
        if (utente!=null)return ResponseEntity.ok().body(utente);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping (value = "/updateUtente")
    public ResponseEntity <Void> updateUtente (@RequestBody Utente utente){
        boolean isUpdated= service.updateUtente(utente);
        if(isUpdated) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping (value = "/deleteUtente")
    public  ResponseEntity <Void> deleteUtente (@RequestParam (value = "id")UUID id){
        boolean deleted = service.deleteUtente(id);
        if (deleted)return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @GetMapping (value = "/getOrganizzati")
    public ResponseEntity<List<Evento>> getOrganizzati(@RequestParam (value = "idOrganizzatore") UUID idOrganizzatore){
        List<Evento> eventiOrganizzati = service.getOrganizzati(idOrganizzatore);
        if(eventiOrganizzati.isEmpty()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok().body(eventiOrganizzati);
    }

    @PostMapping (value = "/createPrenotazione")
    public ResponseEntity<Void> createPrenotazione(@RequestParam(value = "idutente") UUID idutente,@RequestParam(value="idevento") UUID idevento){
            boolean isCreated = servicePren.creaPrenotazione(idutente,idevento);
            if(isCreated) return ResponseEntity.ok().build();
            return ResponseEntity.badRequest().build();
    }

    @GetMapping(value="/getPrenotazioniPassate")
    public ResponseEntity<List<UUID>> getPrenotazioniPassate(@RequestParam(value="idutente") UUID idutente){
        List<UUID> prenotazioniPassate = servicePren.getPrenotazioniPassate(idutente);
        if(prenotazioniPassate.isEmpty()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok().body(prenotazioniPassate);
    }

    @GetMapping(value = "/getPrenotazioniFuture")
    public ResponseEntity<List<UUID>> getPrenotazioniFuture(@RequestParam(value="idutente") UUID idutente){
        List<UUID> prenotazioniFuture = servicePren.getPrenotazioniFuture(idutente);
        if(prenotazioniFuture == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok().body(prenotazioniFuture);
    }

    @PostMapping(value = "/createRecensione")
    public ResponseEntity<Void> createRecensione(@RequestParam(value = "titolo") String titolo, @RequestParam(value = "descrizione") String descrizione, @RequestParam(value = "valutazione") int valutazione, @RequestParam(value = "idprenotazione") UUID idPren){
        boolean isCreated = serviceRec.creaRecensione(titolo,descrizione,valutazione,idPren);
        if(isCreated)return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
