package com.example.demo.Ragazzo_Vacanza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RagazzoVacanzaService {

    private RagazzoVacanzaRepository ragazzoVacanzaRepository;

    @Autowired
    public RagazzoVacanzaService(RagazzoVacanzaRepository ragazzoVacanzaRepository) {
        this.ragazzoVacanzaRepository = ragazzoVacanzaRepository;
    }

    public List<RagazzoVacanza> getAllByIdVacanza(long idVacanza) {
        return ragazzoVacanzaRepository.findAllByRagazzoVacanzaId_IdVacanza(idVacanza);
    }

    public RagazzoVacanza updateRagazzoVacanza(RagazzoVacanza ragazzoVacanza) {
        if(ragazzoVacanza.getQuestionario()!=null){
            ragazzoVacanza.getQuestionario().setId(ragazzoVacanza.getRagazzoVacanzaId());
            ragazzoVacanza.getQuestionario().setRagazzoVacanza(ragazzoVacanza);
        }
        return ragazzoVacanzaRepository.save(ragazzoVacanza);
    }

    public List<RagazzoVacanza> getAllByEmailRagazzo(String emailRagazzo) {
        return ragazzoVacanzaRepository.findAllByRagazzoVacanzaId_EmailRagazzo(emailRagazzo);
    }

    public List<Questionario> getQuestionari(String emailRagazzo) {
        List<RagazzoVacanza> ragazzoVacanzas=ragazzoVacanzaRepository.findAllByRagazzoVacanzaId_EmailRagazzo(emailRagazzo);
        List<Questionario> questionari=ragazzoVacanzas.stream().map(RagazzoVacanza::getQuestionario).collect(Collectors.toList());
    return questionari;
    }

    public List<Questionario> getQuestionariByIdVacanza(long idVacanza) {
        List<RagazzoVacanza> ragazzoVacanzas=ragazzoVacanzaRepository.findAllByRagazzoVacanzaId_IdVacanza(idVacanza);
        List<Questionario> questionari=ragazzoVacanzas.stream().map(RagazzoVacanza::getQuestionario).collect(Collectors.toList());
        return questionari;
    }

    public List<Questionario> getAllQuestionari() {
        List<RagazzoVacanza> ragazzoVacanzas=ragazzoVacanzaRepository.findAll();
        List<Questionario> questionari=ragazzoVacanzas.stream().map(RagazzoVacanza::getQuestionario).collect(Collectors.toList());
        return questionari;
    }
}
