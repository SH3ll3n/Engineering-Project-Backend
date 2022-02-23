package com.example.demo.Gita;


import com.example.demo.Ragazzo.Ragazzo;
import com.example.demo.Ragazzo.RagazzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/gita")
public class GitaController {
    private final GitaService gitaService;

    @Autowired
    public GitaController(GitaService gitaService) {
        this.gitaService = gitaService;
    }

    @GetMapping
    public List<Gita> getGite(){
        return gitaService.getGite();
    }

    @PostMapping
    public void registerNuovaGita(@RequestBody Gita gita) {
        gitaService.addNuovaGita(gita);
    }
}
