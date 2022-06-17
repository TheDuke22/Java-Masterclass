package com.example.allyourevents.controller;

import com.example.allyourevents.models.Evento;
import com.example.allyourevents.models.Stanza;
import com.example.allyourevents.models.Utente;
import com.example.allyourevents.repositories.RepoCRUDUtente;
import com.example.allyourevents.services.CrudService;
import com.example.allyourevents.services.ServiceForEvents;
import com.example.allyourevents.services.ServiceForStanza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.allyourevents.services.ServiceForEvents;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping (value = "/isolaEvent")
public class IsolaController {
    @Autowired
    CrudService service;
    @Autowired
    ServiceForStanza serviceForStanza;
    @Autowired
    ServiceForEvents serviceForEvents;


    public IsolaController(CrudService service, ServiceForEvents serviceForEvents, ServiceForStanza serviceForStanza) {
        this.service = service;
        this.serviceForEvents=serviceForEvents;
        this.serviceForStanza = serviceForStanza;
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


    @PostMapping (value = "/createStanza")
    public ResponseEntity <Void> createStanza(@RequestBody Stanza stanza){
        boolean isCreated = serviceForStanza.createStanza(stanza);
        if (isCreated) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }


    @GetMapping (value = "/getStanza")
    public ResponseEntity <Stanza> getStanza (@RequestParam (value = "id")UUID id ){
        Stanza stanza = serviceForStanza.getStanza(id);
        if (stanza!=null)return ResponseEntity.ok().body(stanza);
        return ResponseEntity.badRequest().build();
    }


    @PutMapping (value = "/updateStanza")
    public ResponseEntity <Void> updateStanza (@RequestBody Stanza stanza){
        boolean isUpdated= serviceForStanza.updateStanza(stanza);
        if(isUpdated) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }


    @DeleteMapping (value = "/deleteStanza")
    public  ResponseEntity <Void> deleteStanza(@RequestParam (value = "id")UUID id){
        boolean deleted = serviceForStanza.deleteStanza(id);
        if (deleted)return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping(value="/createEvento")
    public ResponseEntity<Void> createEvento(@RequestBody Evento evento){
        boolean created=serviceForEvents.createEvent(evento);
        if(created) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value="/getEvento")
    public ResponseEntity<Evento> getEvento(@RequestParam(value="id") UUID id){
        Evento evento= serviceForEvents.getEvento(id);
        if(evento!=null) return ResponseEntity.ok(evento);
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/getEventiDisponibili")
    public ResponseEntity<List<Evento>> getAllEvents(){
        UUID id=new UUID(0,0);
        List<Evento> eventi = serviceForEvents.getAvailableEvents(id);
        if(eventi!=null) return ResponseEntity.ok(eventi);
        return ResponseEntity.badRequest().build();
    }

}
