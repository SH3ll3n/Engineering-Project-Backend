package com.example.demo.Allergia;

import com.example.demo.Ragazzo.Ragazzo;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Embeddable
public class AllergiaId implements Serializable {
    private String nome;

    public String getIdRagazzo() {
        return idRagazzo;
    }

    public void setIdRagazzo(String idRagazzo) {
        this.idRagazzo = idRagazzo;
    }

    private String idRagazzo;

    public AllergiaId(String nome) {
        this.nome = nome;
    }

    public AllergiaId(){
    }

    public AllergiaId(String nome, String idRagazzo) {
        this.nome = nome;
        this.idRagazzo = idRagazzo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}