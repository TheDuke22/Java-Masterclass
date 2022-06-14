package com.example.allyourevents.models;

import java.util.UUID;

public class Preferito {
    private UUID idPreferito;
    private UUID idEvento;
    private UUID idUtente;

    public Preferito(UUID idPreferito, UUID idEvento, UUID idUtente) {
        this.idPreferito = idPreferito;
        this.idEvento = idEvento;
        this.idUtente = idUtente;
    }

    public UUID getIdPreferito() {
        return idPreferito;
    }

    public void setIdPreferito(UUID idPreferito) {
        this.idPreferito = idPreferito;
    }

    public UUID getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(UUID idEvento) {
        this.idEvento = idEvento;
    }

    public UUID getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(UUID idUtente) {
        this.idUtente = idUtente;
    }
}
