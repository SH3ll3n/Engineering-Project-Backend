package com.example.demo.College;

import com.example.demo.Ragazzo.Ragazzo;
import com.example.demo.Ragazzo.Tipo;
import com.example.demo.Ragazzo_Vacanza.RagazzoVacanza;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class College {

    @Id
    private String indirizzo;

    private String nome;

    private String nome_Attivita;
    private String descrizione_Attivita;

    public College() {
    }

    @OneToMany(mappedBy = "college",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<RagazzoVacanza> ragazziVacanza = new HashSet<>();

    public Set<RagazzoVacanza> getRagazziVacanza() {
        return ragazziVacanza;
    }

    public void setRagazziVacanza(Set<RagazzoVacanza> ragazziVacanza) {
        this.ragazziVacanza = ragazziVacanza;
    }

    public College(String indirizzo, String nome, Tipo tipo_Camera, String nome_Attivita, String descrizione_Attivita, Set<RagazzoVacanza> ragazziVacanza) {
        this.indirizzo = indirizzo;
        this.nome = nome;
        this.nome_Attivita = nome_Attivita;
        this.descrizione_Attivita = descrizione_Attivita;
        this.ragazziVacanza = ragazziVacanza;
    }

    public College(String indirizzo, String nome, String nome_Attivita, String descrizione_Attivita) {
        this.indirizzo = indirizzo;
        this.nome = nome;
        this.nome_Attivita = nome_Attivita;
        this.descrizione_Attivita = descrizione_Attivita;
    }

    public College(String nome, String nome_Attivita, String descrizione_Attivita) {
        this.nome = nome;
        this.nome_Attivita = nome_Attivita;
        this.descrizione_Attivita = descrizione_Attivita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_Attivita() {
        return nome_Attivita;
    }

    public void setNome_Attivita(String nome_Attivita) {
        this.nome_Attivita = nome_Attivita;
    }

    public String getDescrizione_Attivita() {
        return descrizione_Attivita;
    }

    public void setDescrizione_Attivita(String descrizione_Attivita) {
        this.descrizione_Attivita = descrizione_Attivita;
    }

    @Override
    public String toString() {
        return "College{" +
                "indirizzo='" + indirizzo + '\'' +
                ", nome='" + nome + '\'' +
                ", nome_Attivita='" + nome_Attivita + '\'' +
                ", descrizione_Attivita='" + descrizione_Attivita + '\'' +
                '}';
    }
}
