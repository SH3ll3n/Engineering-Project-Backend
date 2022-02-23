package com.example.demo.Ragazzo_Vacanza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RagazzoVacanzaRepository extends
        JpaRepository<RagazzoVacanza, RagazzoVacanzaId> {

     List<RagazzoVacanza> findAllByRagazzoVacanzaId_IdVacanza(long idVacanza);

     List<RagazzoVacanza> findAllByRagazzoVacanzaId_EmailRagazzo(String emailRagazzo);
}
