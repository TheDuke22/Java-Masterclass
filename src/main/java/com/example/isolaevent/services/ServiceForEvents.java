package com.example.isolaevent.services;

import com.example.isolaevent.models.Evento;
import com.example.isolaevent.repositories.RepoCRUDEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceForEvents {
    @Autowired
    RepoCRUDEvento repoForEvents;

    public ServiceForEvents(RepoCRUDEvento repoForEvents) {
        this.repoForEvents = repoForEvents;
    }

    public boolean createEvent(Evento evento){
        //controlla che l'orario di inizio non sia un orario
        if(evento.getDataOraInizio().isBefore(LocalDateTime.now())){
            System.out.println("La data e l'orario sono già passate");
            return false;
        }
        return repoForEvents.createEvent(evento);
    }

    public Evento getEvento(UUID id){
        return repoForEvents.getEvento(id);
    }

    public Evento getAvailableEvents(UUID id){
        return repoForEvents.getAvailableEvent(id);
    }

    public List<Evento> getAllEvents(){
        return repoForEvents.getAllEvents();
    }
}
