package com.example.allyourevents.services;

import com.example.allyourevents.repositories.RepoCRUDPreferito;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServicePreferiti {
    private RepoCRUDPreferito repoPreferito;

    ServicePreferiti(RepoCRUDPreferito repoPreferito){
        this.repoPreferito = repoPreferito;
    }

    public boolean inserisciPreferito(UUID idUtente, UUID idEvento){
        return repoPreferito.inserisciPreferito(idUtente,idEvento);
    }

    public boolean removePreferito(UUID idUtente, UUID idEvento){
        return repoPreferito.removePreferito(idUtente, idEvento);
    }

    public List<UUID> getPreferiti(UUID idUtente){
        return repoPreferito.getPreferiti(idUtente);
    }
}
