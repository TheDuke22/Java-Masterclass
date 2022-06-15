package com.example.allyourevents.models;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class Evento {

    private UUID id;
    private String titolo;
    private String descrizione;
    private Timestamp data_ora_inizio;
    private Timestamp data_ora_fine;
    private Float prezzo;
    private UUID idStanza;
    private UUID idOrganizzatore;

    public Evento(String titolo, String descrizione, Timestamp data_ora_inizio, Timestamp data_ora_fine, Float prezzo, UUID idStanza, UUID idOrganizzatore) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.data_ora_inizio = data_ora_inizio;
        this.data_ora_fine = data_ora_fine;
        this.prezzo = prezzo;
        this.idStanza = idStanza;
        this.idOrganizzatore = idOrganizzatore;
    }

    public Evento(){}

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

    public Timestamp getDataOraInizio() {
        return data_ora_inizio;
    }
    public void setDataOraInizio(Timestamp data_ora_inizio) {
        this.data_ora_inizio = data_ora_inizio;
    }

    public Timestamp getDataOraFine(){
        return data_ora_fine;
    }
    public void setDataOraFine(Timestamp data_ora_fine){
        this.data_ora_fine = data_ora_fine;
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
