package com.example.allyourevents.services;

import com.example.allyourevents.models.Stanza;
import com.example.allyourevents.repositories.RepoCRUDStanza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ServiceForStanza {

    @Autowired
    RepoCRUDStanza repositoryForStanza;

    public ServiceForStanza(RepoCRUDStanza repositoryForStanza) {
        this.repositoryForStanza = repositoryForStanza;
    }


    public boolean createStanza(Stanza stanza){
        return repositoryForStanza.createStanza(stanza);
    }


    public Stanza getStanza(UUID id){
        return repositoryForStanza.getStanza(id);
    }


    public boolean updateStanza(Stanza stanza){
        return repositoryForStanza.updateStanza(stanza);
    }



    public boolean deleteStanza(UUID id){
        return repositoryForStanza.deleteStanza(id);
    }
}
