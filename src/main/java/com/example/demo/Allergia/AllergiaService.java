package com.example.demo.Allergia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllergiaService {

    private final AllergiaRepository allergiaRepository;

    @Autowired
    public AllergiaService(AllergiaRepository allergiaRepository) {
        this.allergiaRepository = allergiaRepository;
    }

    public List<Allergia> getAllergia(){
        return  allergiaRepository.findAll();
    }

    //sostituisci con findById
    public void addNuovaAllergia(Allergia allergia) {
        AllergiaId allergiaId = allergia.getId();
        Optional<Allergia> allergiaOptional= allergiaRepository
                .findAllergiaById_Nome(allergiaId.getNome());
        if (allergiaOptional.isPresent()){
            throw new IllegalStateException("allergia taken");
        }
        allergiaRepository.save(allergia);
    }

    public void deleteAllergia(AllergiaId id) {
        boolean exists = allergiaRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "allergia with id " + id + " does not exists");
        }
        allergiaRepository.deleteById(id);
    }

    public void updateAllergia(AllergiaId id, String precauzione) {
    }
}
