package com.example.isolaevent.models;

import java.util.Date;
import java.util.UUID;

public class Utente {
    private UUID id;
    private String nome;
    private String cognome;
    private String email;
    private Date dataDiNascita;
    private Float portafoglio;

    public Utente() {
    }

    public Utente(String nome, String cognome, String email, Date dataDiNascita, Float portafoglio) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.portafoglio = portafoglio;
    }

    public Utente(UUID id, String nome, String cognome, String email, Date dataDiNascita, Float portafoglio) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.portafoglio = portafoglio;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Float getPortafoglio() {
        return portafoglio;
    }

    public void setPortafoglio(Float portafoglio) {
        this.portafoglio = portafoglio;
    }
}
