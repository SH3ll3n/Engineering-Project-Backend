package com.example.demo.Ragazzo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.RandomAccess;

@RestController
@RequestMapping(path = "api/v1/guy")
public class RagazzoController {

    private final RagazzoService ragazzoService;

    @Autowired
    public RagazzoController(RagazzoService ragazzoService) {

        this.ragazzoService = ragazzoService;
    }

    @GetMapping
    public List<Ragazzo> getRagazzi(){

        return ragazzoService.getRagazzi();
    }

   @GetMapping(path="/email")
    public List<String> getEmail(){
        return ragazzoService.getEmail();
    }

    @GetMapping(path = "/{ragazzoEmail}")
    public Ragazzo findRagazzoByEmail(@PathVariable String ragazzoEmail) {
        return ragazzoService.findRagazzoByEmail(ragazzoEmail);
    }

    @PostMapping
    public void registerNuovoRagazzo(@RequestBody Ragazzo ragazzo) {
        ragazzoService.addNuovoRagazzo(ragazzo);
    }

    @PutMapping(path="/compagno")
    public void associaCompagno(@RequestBody Ragazzo ragazzo){
        ragazzoService.associaCompagno(ragazzo);
    }

    @PutMapping
    public Ragazzo addVacanze(@RequestBody Ragazzo ragazzo){
        return ragazzoService.addVacanze(ragazzo);
    }

    @PutMapping(path ="/modifica")
    public Ragazzo modificaRagazzo(@RequestBody Ragazzo ragazzo) {return  ragazzoService.modificaRagazzo(ragazzo); }
}
