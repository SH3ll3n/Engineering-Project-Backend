package com.example.demo.Ragazzo_Vacanza;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RagazzoVacanzaId implements Serializable {

    private String emailRagazzo;
    private long idVacanza;

    public String getEmailRagazzo() {
        return emailRagazzo;
    }

    public void setEmailRagazzo(String emailRagazzo) {
        this.emailRagazzo = emailRagazzo;
    }

    public long getIdVacanza() {
        return idVacanza;
    }

    public void setIdVacanza(long idVacanza) {
        this.idVacanza = idVacanza;
    }

    public RagazzoVacanzaId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RagazzoVacanzaId that = (RagazzoVacanzaId) o;
        return idVacanza == that.idVacanza && Objects.equals(emailRagazzo, that.emailRagazzo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailRagazzo, idVacanza);
    }

    public RagazzoVacanzaId(String emailRagazzo, long idVacanza) {
        this.emailRagazzo = emailRagazzo;
        this.idVacanza = idVacanza;
    }
}
