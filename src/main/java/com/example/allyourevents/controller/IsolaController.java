package com.example.allyourevents.controller;

import com.example.allyourevents.models.Utente;
import com.example.allyourevents.repositories.RepoCRUDUtente;
import com.example.allyourevents.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping (value = "/isolaEvent")
public class IsolaController {
    @Autowired
    CrudService service;

    public IsolaController(CrudService service) {
        this.service = service;
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

}
