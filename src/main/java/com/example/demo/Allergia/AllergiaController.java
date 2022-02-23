package com.example.demo.Allergia;

import com.example.demo.Ragazzo.Ragazzo;
import com.example.demo.Ragazzo.RagazzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/allergia")
public class AllergiaController {

    private final AllergiaService allergiaService;

    @Autowired
    public AllergiaController(AllergiaService allergiaService) {

        this.allergiaService = allergiaService;
    }

    @GetMapping
    public List<Allergia> getAllergia(){

        return allergiaService.getAllergia();
    }

    @PostMapping
    public void registerNuovaAllergia(@RequestBody Allergia allergia) {
        allergiaService.addNuovaAllergia(allergia);
    }
}
