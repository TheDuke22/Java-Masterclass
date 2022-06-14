package com.example.allyourevents.models;

import java.util.UUID;

public class Recensione {
    private UUID id;
    private String titolo;
    private String descrizione;
    private Short valutazione;
    private UUID idUtente;
    private UUID idOrganizzatore;

    public Recensione(UUID id, String titolo, String descrizione, Short valutazione, UUID idUtente, UUID idOrganizzatore) {
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.valutazione = valutazione;
        this.idUtente = idUtente;
        this.idOrganizzatore = idOrganizzatore;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Short getValutazione() {
        return valutazione;
    }

    public void setValutazione(Short valutazione) {
        this.valutazione = valutazione;
    }

    public UUID getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(UUID idUtente) {
        this.idUtente = idUtente;
    }

    public UUID getIdOrganizzatore() {
        return idOrganizzatore;
    }

    public void setIdOrganizzatore(UUID idOrganizzatore) {
        this.idOrganizzatore = idOrganizzatore;
    }
}
