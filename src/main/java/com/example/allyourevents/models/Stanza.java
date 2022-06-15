package com.example.allyourevents.models;

import java.util.UUID;

public class Stanza {
    private UUID id;
    private String nome;
    private int posti_Disp;
    private Short capienza;

    public Stanza(UUID id, String nome, Short capienza) {
        this.id = id;
        this.nome = nome;
        this.capienza = capienza;
        posti_Disp = this.capienza;
    }

    public int getPosti_Disp() {
        return posti_Disp;
    }
    public void setPosti_Disp(int posti_Disp) {
        this.posti_Disp = posti_Disp;
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

    public Short getCapienza() {
        return capienza;
    }

    public void setCapienza(Short capienza) {
        this.capienza = capienza;
    }
}
