package com.example.demo.Gita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GitaService {

    private final GitaRepository gitaRepository;

    @Autowired
    public GitaService(GitaRepository gitaRepository) {
        this.gitaRepository = gitaRepository;
    }

    public List<Gita> getGite(){
        return gitaRepository.findAll();
    }

    public void addNuovaGita(Gita gita) {
        Optional<Gita> gitaOptional= gitaRepository
                .findById(gita.getId());
        if (gitaOptional.isPresent()){
            throw new IllegalStateException("destinazione taken");
        }
        if (gita.getVacanza() != null) {
            gita.getVacanza().getGite().add(gita);
        }
        gitaRepository.save(gita);
    }

}
