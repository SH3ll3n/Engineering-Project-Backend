package com.example.demo.Vacanza;

import com.example.demo.Genitore.Genitore;
import com.example.demo.Ragazzo.Ragazzo;
import com.example.demo.Ragazzo.RagazzoRepository;
import com.example.demo.Ragazzo_Vacanza.RagazzoVacanza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VacanzaService {

    private final VacanzaRepository vacanzaRepository;

    @Autowired
    public VacanzaService(VacanzaRepository vacanzaRepository) {
        this.vacanzaRepository = vacanzaRepository;
    }

    public List<Vacanza> getVacanza(){
        return  vacanzaRepository.findAll();
    }

    public List<Ragazzo> getIscritti(Long idVacanza) {
        Optional<Vacanza> vacanza=vacanzaRepository.findById(idVacanza);
        List<Ragazzo> ragazzi= vacanza.get().getRagazzoVacanza().stream().map(RagazzoVacanza::getRagazzo).collect(Collectors.toList());
        return ragazzi;
    }

    public void addNuovaVacanza(Vacanza vacanza) {
        Optional<Vacanza> vacanzaOptional= vacanzaRepository.findById(vacanza.getId());
        if (vacanzaOptional.isPresent()){
            throw new IllegalStateException("id taken");
        }
        vacanza.getGite().forEach(gita -> gita.setVacanza(vacanza));
//        Vacanza vacanza1=vacanzaRepository.save(vacanza);
        vacanzaRepository.save(vacanza);
    }
}
