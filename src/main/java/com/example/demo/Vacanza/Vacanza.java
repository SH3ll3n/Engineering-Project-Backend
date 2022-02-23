package com.example.demo.Vacanza;

import com.example.demo.Gita.Gita;
import com.example.demo.Ragazzo_Vacanza.RagazzoVacanza;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Vacanza {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    private String citta;
    private LocalDate data;
    private Integer numeroSettimane;
    private String linguaStudiata;


    public Vacanza() {
    }

    public Set<Gita> getGite() {
        return gite;
    }

    public void setGite(Set<Gita> gite) {
        this.gite = gite;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacanza")
    private Set<Gita> gite = new HashSet<>();

    public Vacanza(Long id, String citta, LocalDate data, Integer numeroSettimane, String linguaStudiata, Set<RagazzoVacanza> ragazzoVacanza) {
        this.id = id;
        this.citta = citta;
        this.data = data;
        this.numeroSettimane = numeroSettimane;
        this.linguaStudiata = linguaStudiata;
        this.ragazzoVacanza = ragazzoVacanza;
    }

    @JsonIgnore
    public Set<RagazzoVacanza> getRagazzoVacanza() {
        return ragazzoVacanza;
    }

    public void setRagazzoVacanza(Set<RagazzoVacanza> ragazzoVacanza) {
        this.ragazzoVacanza = ragazzoVacanza;
    }

    //ragazzo_vacanza
    @OneToMany(mappedBy = "vacanza", cascade = CascadeType.ALL)
    private Set<RagazzoVacanza> ragazzoVacanza=new HashSet<>();

    public Vacanza(Long id, String citta, LocalDate data, Integer numeroSettimane, String linguaStudiata) {
        this.id = id;
        this.citta = citta;
        this.data = data;
        this.numeroSettimane = numeroSettimane;
        this.linguaStudiata = linguaStudiata;
    }

    public Vacanza(String citta, LocalDate data, Integer numeroSettimane, String linguaStudiata) {
        this.citta = citta;
        this.data = data;
        this.numeroSettimane = numeroSettimane;
        this.linguaStudiata = linguaStudiata;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getNumeroSettimane() {
        return numeroSettimane;
    }

    public void setNumeroSettimane(Integer numeroSettimane) {
        this.numeroSettimane = numeroSettimane;
    }

    public String getLinguaStudiata() {
        return linguaStudiata;
    }

    public void setLinguaStudiata(String linguaStudiata) {
        this.linguaStudiata = linguaStudiata;
    }

    @Override
    public String toString() {
        return "Vacanza{" +
                "id=" + id +
                ", citta='" + citta + '\'' +
                ", data=" + data +
                ", numeroSettimane=" + numeroSettimane +
                ", linguaStudiata='" + linguaStudiata + '\'' +
                '}';
    }
}
