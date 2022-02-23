package com.example.demo.Genitore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/genitore")
public class GenitoreController {

    private final GenitoreService genitoreService;

    @Autowired
    public GenitoreController(GenitoreService genitoreService) {

        this.genitoreService = genitoreService;
    }

    @GetMapping
    public List<Genitore> getGenitori(){

        return genitoreService.getGenitori();
    }

    @PostMapping
    public void registerNuovoGenitore(@RequestBody Genitore genitore) {
        genitoreService.addNuovoGenitore(genitore);
    }

    @PutMapping(path = "{genitoreEmail}")
    public void updateGenitore(
            @PathVariable("genitoreEmail") String email,
            @RequestParam(required = false) String nome) {
        genitoreService.updateGenitore(nome, email);
    }
}
