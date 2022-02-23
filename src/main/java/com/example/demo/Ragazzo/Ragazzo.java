package com.example.demo.Ragazzo;

import com.example.demo.Allergia.Allergia;
import com.example.demo.College.College;
import com.example.demo.Famiglia.Famiglia;
import com.example.demo.Genitore.Genitore;
import com.example.demo.Ragazzo_Vacanza.RagazzoVacanza;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Ragazzo {

    @Id
    private String email;

    private String nome;
    private String cognome;
    private LocalDate dataNascita;

    private String indirizzo;
    private String password;
    private String telefono;
    private String hobby;


    public Ragazzo(String email, String nome, String cognome, LocalDate dataNascita, String indirizzo, String password, String telefono, String  hobby, Genitore genitore) {
        this.email=email;
        this.nome=nome;
        this.cognome=cognome;
        this.dataNascita=dataNascita;
        this.indirizzo=indirizzo;
        this.password=password;
        this.telefono=telefono;
        this.hobby=hobby;
    }

    public Ragazzo(String email, String nome, String cognome, LocalDate dataNascita, String indirizzo, String password, String telefono, String hobby, Set<Allergia> allergie, Set<Genitore> genitori) {
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.indirizzo = indirizzo;
        this.password = password;
        this.telefono = telefono;
        this.hobby = hobby;
        this.allergie = allergie;
        this.genitori = genitori;
    }


    public Set<RagazzoVacanza> getRagazziVacanze() {
        return ragazziVacanze;
    }

    public void setRagazziVacanze(Set<RagazzoVacanza> ragazziVacanze) {
        this.ragazziVacanze = ragazziVacanze;
    }

    //ragazzo_vacanza
    @OneToMany(mappedBy = "ragazzo", cascade = CascadeType.ALL)
    private Set<RagazzoVacanza> ragazziVacanze =new HashSet<>();

    public Ragazzo(String email, String nome, String cognome, LocalDate dataNascita, String indirizzo, String password, String telefono, String hobby, Set<Allergia> allergie, Set<Genitore> genitori, Set<RagazzoVacanza> ragazziVacanze) {
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.indirizzo = indirizzo;
        this.password = password;
        this.telefono = telefono;
        this.hobby = hobby;
        this.allergie = allergie;
        this.genitori = genitori;
        this.ragazziVacanze = ragazziVacanze;
    }

    public Set<Allergia> getAllergie() {
        return allergie;
    }

    public void setAllergie(Set<Allergia> allergie) {
        this.allergie = allergie;
    }

    //relazione allergie
    @OneToMany(mappedBy = "ragazzo",cascade = CascadeType.ALL)
    private Set<Allergia> allergie =new HashSet<>();

    //relazione genitore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable

    private Set<Genitore> genitori= new HashSet<>();

    public Set<Genitore> getGenitori() {return genitori;}
    public void setGenitori(Set<Genitore> genitori) {this.genitori= genitori;}

    public Ragazzo() {
    }

    public Ragazzo(String email, String nome, String cognome, LocalDate dataNascita, String indirizzo, String password, String telefono, String hobby) {
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.indirizzo = indirizzo;
        this.password = password;
        this.telefono = telefono;
        this.hobby = hobby;
    }

    public Ragazzo(String nome, String cognome, LocalDate dataNascita, String indirizzo, String password, String telefono, String hobby) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.indirizzo = indirizzo;
        this.password = password;
        this.telefono = telefono;
        this.hobby = hobby;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Ragazzo{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", indirizzo='" + indirizzo + '\'' +
                ", password='" + password + '\'' +
                ", telefono=" + telefono +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
