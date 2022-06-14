package com.example.allyourevents.models;

import java.util.UUID;

public class Prenota {
    private UUID idPrenotazione;
    private UUID idUtente;
    private UUID idEvento;

    public Prenota(UUID idPrenotazione, UUID idUtente, UUID idEvento) {
        this.idPrenotazione = idPrenotazione;
        this.idUtente = idUtente;
        this.idEvento = idEvento;
    }

    public UUID getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(UUID idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public UUID getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(UUID idUtente) {
        this.idUtente = idUtente;
    }

    public UUID getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(UUID idEvento) {
        this.idEvento = idEvento;
    }
}
