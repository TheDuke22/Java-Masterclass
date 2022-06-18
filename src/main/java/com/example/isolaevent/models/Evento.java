package com.example.isolaevent.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Evento {

    private UUID id;
    private String titolo;
    private String descrizione;

    private LocalDateTime dataOraInizio;
    private LocalDateTime dataOraFine;
    private Float prezzo;
    private UUID idStanza;
    private UUID idOrganizzatore;

    public Evento(String titolo, String descrizione, LocalDateTime dataOraInizio, LocalDateTime dataOraFine, Float prezzo, UUID idStanza, UUID idOrganizzatore) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.dataOraInizio = dataOraInizio;
        this.dataOraFine = dataOraFine;
        this.prezzo = prezzo;
        this.idStanza = idStanza;
        this.idOrganizzatore = idOrganizzatore;
    }

    public Evento(){}

    public Evento(UUID id,String titolo, String descrizione, LocalDateTime dataOraInizio, LocalDateTime dataOraFine, Float prezzo, UUID idStanza, UUID idOrganizzatore) {
        this.id=id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.dataOraInizio = dataOraInizio;
        this.dataOraFine = dataOraFine;
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

    public LocalDateTime getDataOraInizio() {
        return dataOraInizio;
    }

    public LocalDateTime getDataOraFine() {
        return dataOraFine;
    }

    public void setDataOraInizio(LocalDateTime dataOraInizio) {
        this.dataOraInizio = dataOraInizio;
    }

    public void setDataOraFine(LocalDateTime dataOraFine) {
        this.dataOraFine = dataOraFine;
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
