package com.example.allyourevents.models;

import java.util.UUID;

public class Stanza {
    private UUID id;
    private String nome;
    private Short capienza;

    public Stanza(UUID id, String nome, Short capienza) {
        this.id = id;
        this.nome = nome;
        this.capienza = capienza;
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
