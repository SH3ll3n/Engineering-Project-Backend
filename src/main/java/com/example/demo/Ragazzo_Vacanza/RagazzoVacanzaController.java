package com.example.demo.Ragazzo_Vacanza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/ragazzoVacanza")
public class RagazzoVacanzaController {

    private RagazzoVacanzaService ragazzoVacanzaService;

    @Autowired
    public RagazzoVacanzaController (RagazzoVacanzaService ragazzoVacanzaService){
        this.ragazzoVacanzaService=ragazzoVacanzaService;
    }

    @GetMapping(path="/{idVacanza}")
    public List<RagazzoVacanza> getAllByIdVacanza(@PathVariable long idVacanza) {
       return ragazzoVacanzaService.getAllByIdVacanza(idVacanza);
    }

    @GetMapping(path="/questionari")
    public List<Questionario> getAllQuestionari() {
        return ragazzoVacanzaService.getAllQuestionari();
    }

    @GetMapping(path="/questionari/{emailRagazzo}")
    public List<Questionario> getQuestionari(@PathVariable String emailRagazzo) {
        return ragazzoVacanzaService.getQuestionari(emailRagazzo);
    }

    @GetMapping(path="/questionari/vacanza/{idVacanza}")
    public List<Questionario> getQuestionariByIdVacanza(@PathVariable long idVacanza) {
        return ragazzoVacanzaService.getQuestionariByIdVacanza(idVacanza);
    }

    @PutMapping(path ="/update")
    public RagazzoVacanza updateRagazzoVacanza(@RequestBody RagazzoVacanza ragazzoVacanza) {
        if (ragazzoVacanza.getQuestionario() != null) {
            ragazzoVacanza.getQuestionario().setRagazzoVacanza(ragazzoVacanza);
        }
        return  ragazzoVacanzaService.updateRagazzoVacanza(ragazzoVacanza);
    }

}
