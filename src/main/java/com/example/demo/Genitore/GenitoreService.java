package com.example.demo.Genitore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GenitoreService {

    private final GenitoreRepository genitoreRepository;

    @Autowired
    public GenitoreService(GenitoreRepository genitoreRepository) {
        this.genitoreRepository = genitoreRepository;
    }

    public List<Genitore> getGenitori(){
        return  genitoreRepository.findAll();
    }

    public void addNuovoGenitore(Genitore genitore) {
        Optional<Genitore> genitoreOptional= genitoreRepository
                .findGenitoreByEmail(genitore.getEmail());
        if (genitoreOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        genitoreRepository.save(genitore);
    }

    public void deleteGenitore(String email) {
        boolean exists = genitoreRepository.existsByEmail(email);
        if (!exists) {
            throw new IllegalStateException(
                    "genitore with email " + email + " does not exists");
        }
        genitoreRepository.deleteByEmail(email);
    }

    public void updateGenitore(String nome, String email) {
    }

    public Genitore addGenitore(Genitore genitore) {
        if (genitore.getRagazzi().isEmpty()) {
            genitore.getRagazzi().forEach(s -> s.getGenitori().add(genitore));
        }
        return genitoreRepository.save(genitore);
    }
}
