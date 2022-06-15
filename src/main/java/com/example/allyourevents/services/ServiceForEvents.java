package com.example.allyourevents.services;

import com.example.allyourevents.models.Evento;
import com.example.allyourevents.repositories.EventsCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceForEvents {
    @Autowired
    EventsCrudRepo repoForEvents;

    public ServiceForEvents(EventsCrudRepo repoForEvents) {
        this.repoForEvents = repoForEvents;
    }

    public boolean createEvent(Evento evento){
        //controlla che l'orario di inizio non sia un orario
        if(evento.getDataOraInizio().toLocalDateTime().isBefore(LocalDateTime.now())){
            System.out.println("La data e l'orario sono già passate");
            return false;
        }
        return repoForEvents.createEvent(evento);
    }

    public Evento getEvento(UUID id){
        return repoForEvents.getEvento(id);
    }

    public List<Evento> getAvailableEvents(UUID id){
        return repoForEvents.getAllEvents(id);
    }
}
