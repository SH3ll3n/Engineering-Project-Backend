package com.example.demo.College;

import com.example.demo.Ragazzo.Ragazzo;
import com.example.demo.Ragazzo.RagazzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/college")
public class CollegeController {

    private final CollegeService collegeService;

    @Autowired
    public CollegeController(CollegeService collegeService) {

        this.collegeService = collegeService;
    }

    @GetMapping
    public List<College> getCollege(){
        return collegeService.getCollege();
    }

    @PostMapping
    public void registerNuovoCollege(@RequestBody College college) {
        collegeService.addNuovoCollege(college);
    }

    @PutMapping(path = "/{collegeIndirizzo}")
    public void updateCollege(
            @PathVariable("collegeIndirizzo") String collegeIndirizzo,
            @RequestParam(required = false) String nome) {
        collegeService.updateCollege(collegeIndirizzo, nome);
    }
}
