package com.example.demo.Famiglia;

import com.example.demo.Ragazzo.Ragazzo;
import com.example.demo.Ragazzo.RagazzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/famiglia")
public class FamigliaController {

    private final FamigliaService famigliaService;

    @Autowired
    public FamigliaController(FamigliaService famigliaService) {
        this.famigliaService = famigliaService;
    }

    @GetMapping
    public List<Famiglia> getFamiglie(){

        return famigliaService.getFamiglie();
    }

    @PostMapping
    public void registerNuovaFamiglia(@RequestBody Famiglia famiglia) {
        famigliaService.addNuovaFamiglia(famiglia);
    }

    @PutMapping(path = "/{famigliaNome}")
    public void updateFamiglia(
            @PathVariable("famigliaNome") String famigliaNome,
            @RequestParam(required = false) String cognome_Capo) {
        famigliaService.updateFamiglia(famigliaNome, cognome_Capo);
    }
}
