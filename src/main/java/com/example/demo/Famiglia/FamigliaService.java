package com.example.demo.Famiglia;

import com.example.demo.Ragazzo.Ragazzo;
import com.example.demo.Ragazzo.RagazzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FamigliaService {

    private final FamigliaRepository famigliaRepository;

    @Autowired
    public FamigliaService(FamigliaRepository famigliaRepository) {
        this.famigliaRepository = famigliaRepository;
    }

    public List<Famiglia> getFamiglie(){
        return famigliaRepository.findAll();
    }

    public void addNuovaFamiglia(Famiglia famiglia) {
        Optional<Famiglia> famigliaOptional= famigliaRepository
                .findById(famiglia.getNome_Capo());
        if (famigliaOptional.isPresent()){
            throw new IllegalStateException("nome taken");
        }
        famigliaRepository.save(famiglia);
    }

    public void deleteFamiglia(String nome_Capo) {
        boolean exists = famigliaRepository.existsById(nome_Capo);
        if (!exists) {
            throw new IllegalStateException(
                    "famiglia with nome " + nome_Capo + " does not exists");
        }
        famigliaRepository.deleteById(nome_Capo);
    }

    @Transactional
    public void updateFamiglia(String nome_Capo,
                              String cognome_Capo) {
        Famiglia famiglia = famigliaRepository.findById(nome_Capo)
                .orElseThrow(() -> new IllegalStateException(
                        "famiglia with nome " + nome_Capo + " does not exist"));
        if (nome_Capo != null &&
                nome_Capo.length() > 0 &&
                !Objects.equals(famiglia.getNome_Capo(), nome_Capo)) {
            famiglia.setNome_Capo(nome_Capo);
        }
    }
}

