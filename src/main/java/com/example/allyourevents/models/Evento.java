package com.example.allyourevents.models;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

public class Evento {

    private UUID id;
    private String titolo;
    private String descrizione;
    private Date data;
    private Time oraInizio;
    private Time oraFine;
    private Float prezzo;
    private UUID idStanza;
    private UUID idOrganizzatore;

    public Evento(UUID id, String titolo, String descrizione, Date data, Time oraInizio, Time oraFine, Float prezzo, UUID idStanza, UUID idOrganizzatore) {
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.prezzo = prezzo;
        this.idStanza = idStanza;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(Time oraInizio) {
        this.oraInizio = oraInizio;
    }

    public Time getOraFine() {
        return oraFine;
    }

    public void setOraFine(Time oraFine) {
        this.oraFine = oraFine;
    }

    public Float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Float prezzo) {
        this.prezzo = prezzo;
    }

    public UUID getIdStanza() {
        return idStanza;
    }

    public void setIdStanza(UUID idStanza) {
        this.idStanza = idStanza;
    }

    public UUID getIdOrganizzatore() {
        return idOrganizzatore;
    }

    public void setIdOrganizzatore(UUID idOrganizzatore) {
        this.idOrganizzatore = idOrganizzatore;
    }
}
