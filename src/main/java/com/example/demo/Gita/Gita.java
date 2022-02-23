package com.example.demo.Gita;

import com.example.demo.Vacanza.Vacanza;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Gita {

    public GitaId getId() {
        return id;
    }

    public void setId(GitaId id) {
        this.id = id;
    }


    @EmbeddedId
    private GitaId id;

    private String descrizione;
    private Integer costo;
    private Integer numero_Ore;

    public Gita() {
    }

    public Gita(GitaId id, String descrizione, Integer costo, Integer numero_Ore, Vacanza vacanza) {
        this.id = id;
        this.descrizione = descrizione;
        this.costo = costo;
        this.numero_Ore = numero_Ore;
        this.vacanza = vacanza;
    }

    @JsonIgnore
    public Vacanza getVacanza() {
        return vacanza;
    }

    public void setVacanza(Vacanza vacanza) {
        this.vacanza = vacanza;
    }

    @ManyToOne(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn(name = "idVacanza", referencedColumnName = "id")
    @MapsId("idVacanza")
    private Vacanza vacanza;

    public Gita(GitaId id, String descrizione, Integer costo, Integer numero_Ore) {
        this.id = id;
        this.descrizione = descrizione;
        this.costo = costo;
        this.numero_Ore = numero_Ore;
    }

    public Gita(String descrizione, Integer costo, Integer numero_Ore) {
        this.descrizione = descrizione;
        this.costo = costo;
        this.numero_Ore = numero_Ore;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Integer getNumero_Ore() {
        return numero_Ore;
    }

    public void setNumero_Ore(Integer numero_Ore) {
        this.numero_Ore = numero_Ore;
    }

    @Override
    public String toString() {
        return "Gita{" +
                "id='" + id + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", costo=" + costo +
                ", numero_Ore=" + numero_Ore +
                '}';
    }
}




