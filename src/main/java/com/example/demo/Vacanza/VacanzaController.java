package com.example.demo.Vacanza;

import com.example.demo.Ragazzo.Ragazzo;
import com.example.demo.Ragazzo.RagazzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/vacanza")
public class VacanzaController {

    private final VacanzaService vacanzaService;

    @Autowired
    public VacanzaController(VacanzaService vacanzaService) {

        this.vacanzaService = vacanzaService;
    }

    @GetMapping
    public List<Vacanza> getVacanze(){

        return vacanzaService.getVacanza();
    }

    @GetMapping(path="/{idVacanza}")
    public List<Ragazzo> getIscritti(@PathVariable Long idVacanza){
        return vacanzaService.getIscritti(idVacanza);
    }

    @PostMapping
    public void registerNuovaVacanza(@RequestBody Vacanza vacanza) {
        vacanzaService.addNuovaVacanza(vacanza);
    }

}
