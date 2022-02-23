package com.example.demo.Responsabile;

import com.example.demo.Ragazzo.Ragazzo;
import com.example.demo.Ragazzo.RagazzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ResponsabileService {

    private final ResponsabileRepository responsabileRepository;

    @Autowired
    public ResponsabileService(ResponsabileRepository responsabileRepository) {
        this.responsabileRepository = responsabileRepository;
    }

    public List<Responsabile> getResponsabili(){
        return  responsabileRepository.findAll();
    }

    public void addNuovoResponsabile(Responsabile responsabile) {
        Optional<Responsabile> responsabileOptional= responsabileRepository
                .findById(responsabile.getEmail());
        if (responsabileOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        responsabileRepository.save(responsabile);
    }

    public void deleteResponsabile(String responsabileEmail) {
        boolean exists = responsabileRepository.existsById(responsabileEmail);
        if (!exists) {
            throw new IllegalStateException(
                    "responsabile with email " + responsabileEmail + " does not exists");
        }
        responsabileRepository.deleteById(responsabileEmail);
    }

    @Transactional
    public void updateResponsabile(String responsabileEmail,
                              String nome) {
        Responsabile responsabile = responsabileRepository.findById(responsabileEmail)
                .orElseThrow(() -> new IllegalStateException(
                        "responsabile with email " + responsabileEmail + " does not exist"));
        if (nome != null &&
                nome.length() > 0 &&
                !Objects.equals(responsabile.getNome(), nome)) {
            responsabile.setNome(nome);
        }
    }
}
