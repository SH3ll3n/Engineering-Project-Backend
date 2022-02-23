package com.example.demo.Ragazzo_Vacanza;

import com.example.demo.College.College;
import com.example.demo.Famiglia.Famiglia;
import com.example.demo.Ragazzo.Ragazzo;
import com.example.demo.Ragazzo.Tipo;
import com.example.demo.Vacanza.Vacanza;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class RagazzoVacanza {

    @EmbeddedId
    private RagazzoVacanzaId ragazzoVacanzaId = new RagazzoVacanzaId();

    public RagazzoVacanza(){
    }

    @Enumerated
    private Tipo tipo_Camera;

    public Tipo getTipo_Camera() {
        return tipo_Camera;
    }

    public void setTipo_Camera(Tipo tipo_Camera) {
        this.tipo_Camera = tipo_Camera;
    }

    public String getNome_Amico() {
        return nome_Amico;
    }

    public void setNome_Amico(String nome_Amico) {
        this.nome_Amico = nome_Amico;
    }

    public String getEmail_Amico() {
        return email_Amico;
    }

    public void setEmail_Amico(String email_Amico) {
        this.email_Amico = email_Amico;
    }

    private String nome_Amico;
    private String email_Amico;

    @Enumerated
    private Livello livello;

    @Enumerated
    private Pagamento pagamento;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
  //  @PrimaryKeyJoinColumn(name = "emailRagazzo",referencedColumnName ="email" )
    @MapsId("emailRagazzo")
    @JoinColumn
    private Ragazzo ragazzo;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
    //@PrimaryKeyJoinColumn(name = "idVacanza",referencedColumnName = "id")
    @MapsId("idVacanza")
    @JoinColumn
    private Vacanza vacanza;

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    @OneToOne(mappedBy = "ragazzoVacanza", cascade = CascadeType.ALL)
    private Questionario questionario;

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public Famiglia getFamiglia() {
        return famiglia;
    }

    public void setFamiglia(Famiglia famiglia) {
        this.famiglia = famiglia;
    }

    //relazione college
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn
    private College college;

    //relazione famiglia
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn
    private Famiglia famiglia;


    public RagazzoVacanza(RagazzoVacanzaId ragazzoVacanzaId, Livello livello, Pagamento pagamento, Ragazzo ragazzo, Vacanza vacanza) {
        this.ragazzoVacanzaId = ragazzoVacanzaId;
        this.livello = livello;
        this.pagamento = pagamento;
        this.ragazzo = ragazzo;
        this.vacanza = vacanza;
    }

    public RagazzoVacanzaId getRagazzoVacanzaId() {
        return ragazzoVacanzaId;
    }

    public void setRagazzoVacanzaId(RagazzoVacanzaId ragazzoVacanzaId) {
        this.ragazzoVacanzaId = ragazzoVacanzaId;
    }

    public Livello getLivello() {
        return livello;
    }

    public void setLivello(Livello livello) {
        this.livello = livello;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @JsonIgnore
    public Ragazzo getRagazzo() {
        return ragazzo;
    }

    public void setRagazzo(Ragazzo ragazzo) {
        this.ragazzo = ragazzo;
    }

    public Vacanza getVacanza() {
        return vacanza;
    }

    public void setVacanza(Vacanza vacanza) {
        this.vacanza = vacanza;
    }
}
