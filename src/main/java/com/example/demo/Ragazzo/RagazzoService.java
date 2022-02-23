package com.example.demo.Ragazzo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class RagazzoService {

    private final RagazzoRepository ragazzoRepository;

    @Autowired
    public RagazzoService(RagazzoRepository ragazzoRepository) {
        this.ragazzoRepository = ragazzoRepository;
    }

    public List<Ragazzo> getRagazzi() {
        return ragazzoRepository.findAll();
    }

    public List<String> getEmail() {
        List<String> emails = new ArrayList<>();
        ragazzoRepository.findAll().forEach(r -> emails.add(r.getEmail()));
        return emails;
    }

    public void addNuovoRagazzo(Ragazzo ragazzo) {
        Optional<Ragazzo> ragazzoOptional = ragazzoRepository
                .findById(ragazzo.getEmail());
        if (ragazzoOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        if (!ragazzo.getGenitori().isEmpty()) {
            //la relazione va messa in entrambi gli oggetti, per tutti i genitori associo i suoi figli
            ragazzo.getGenitori().forEach(genitore -> genitore.getRagazzi().add(ragazzo));
        }
        if (!ragazzo.getAllergie().isEmpty()) {
            ragazzo.getAllergie().forEach(allergia -> allergia.setRagazzo(ragazzo));
        }
        ragazzoRepository.save(ragazzo);
    }

    @Transactional
    public void updateRagazzo(String nome,
                              String cognome) {
        Ragazzo ragazzo = ragazzoRepository.findById(cognome)
                .orElseThrow(() -> new IllegalStateException(
                        "guy with cognome " + cognome + " does not exist"));
        if (nome != null &&
                nome.length() > 0 &&
                !Objects.equals(ragazzo.getNome(), nome)) {
            ragazzo.setNome(nome);
        }
    }

    public Ragazzo addRagazzo(Ragazzo ragazzo) {
        if (ragazzo.getGenitori() != null) {
            ragazzo.getGenitori().forEach(g -> g.getRagazzi().add(ragazzo));
        } else if (ragazzo.getRagazziVacanze() != null) {
            ragazzo.getRagazziVacanze().forEach(rv -> rv.setRagazzo(ragazzo));
        }
        return ragazzoRepository.save(ragazzo);
    }

    public Ragazzo addVacanze(Ragazzo ragazzo) {
        ragazzo.getRagazziVacanze().forEach(ragazzoVacanza -> {
            ragazzoVacanza.setRagazzo(ragazzo);
            ragazzoVacanza.getVacanza().getRagazzoVacanza().add(ragazzoVacanza);
        });
        ragazzo.getAllergie().forEach(allergia -> allergia.setRagazzo(ragazzo));
        return ragazzoRepository.save(ragazzo);
    }

    public void associaCompagno(Ragazzo ragazzo) {
        ragazzoRepository.save(ragazzo);
    }

    public Ragazzo findRagazzoByEmail(String ragazzoEmail) {
        return ragazzoRepository.findById(ragazzoEmail).get();
    }

    public Ragazzo modificaRagazzo(Ragazzo ragazzo) {
        Ragazzo ragazzo1= ragazzoRepository.findById(ragazzo.getEmail()).get();
        ragazzo1.setNome(ragazzo.getNome());
        ragazzo1.setCognome(ragazzo.getCognome());
        ragazzo1.setDataNascita(ragazzo.getDataNascita());
        return ragazzoRepository.save(ragazzo1);
    }
}
