package com.example.demo.Responsabile;

import com.example.demo.Ragazzo.Ragazzo;
import com.example.demo.Ragazzo.RagazzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/responsabile")
public class ResponsabileController {

    private final ResponsabileService responsabileService;

    @Autowired
    public ResponsabileController(ResponsabileService responsabileService) {

        this.responsabileService = responsabileService;
    }

    @GetMapping
    public List<Responsabile> getResponsabili(){

        return responsabileService.getResponsabili();
    }

    @PostMapping
    public void registerNuovoResponsabile(@RequestBody Responsabile responsabile) {
        responsabileService.addNuovoResponsabile(responsabile);
    }

    @PutMapping(path = "{responsabileEmail}")
    public void updateResponsabile(
            @PathVariable("responsabileEmail") String responsabileEmail,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String email) {
        responsabileService.updateResponsabile(nome, email);
    }
}
