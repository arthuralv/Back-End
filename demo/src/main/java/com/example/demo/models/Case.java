package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Case {
    @Id
    @GeneratedValue
    private long ID;
    
    private String cidade;
    private String casos;

    public Case () {
        super();
    }

    public Case (String cidade, String casos) {
        this.cidade = cidade;
        this.casos = casos;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCasos() {
        return casos;
    }

    public void setCasos(String casos) {
        this.casos = casos;
    }
    
}