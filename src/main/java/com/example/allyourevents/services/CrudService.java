package com.example.allyourevents.services;

import com.example.allyourevents.models.Utente;
import com.example.allyourevents.repositories.RepoCRUDUtente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CrudService {
    @Autowired
    RepoCRUDUtente repositoryForCrud;

    public CrudService(RepoCRUDUtente repositoryForCrud) {
        this.repositoryForCrud = repositoryForCrud;
    }

    public boolean createUtente(Utente utente){
        return repositoryForCrud.createUtente(utente);
    }

    public Utente getUtente(UUID id){
        return repositoryForCrud.getUtente(id);
    }
    public boolean updateUtente(Utente utente){
        return repositoryForCrud.updateUtente(utente);
    }
    public boolean deleteUtente(UUID id){
        return repositoryForCrud.deleteUtente(id);
    }
}
