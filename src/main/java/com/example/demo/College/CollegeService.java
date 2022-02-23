package com.example.demo.College;

import com.example.demo.Ragazzo.Ragazzo;
import com.example.demo.Ragazzo.RagazzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CollegeService {

    private final CollegeRepository collegeRepository;

    @Autowired
    public CollegeService(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    public List<College> getCollege(){
        return  collegeRepository.findAll();
    }

    public void addNuovoCollege(College college) {
        Optional<College> collegeOptional= collegeRepository
                .findCollegeByIndirizzo(college.getIndirizzo());
        if (collegeOptional.isPresent()){
            throw new IllegalStateException("indirizzo taken");
        }
        collegeRepository.save(college);
    }

    public void deleteCollege(String collegeIndirizzo) {
        boolean exists = collegeRepository.existsCollegeByIndirizzo(collegeIndirizzo);
        if (!exists) {
            throw new IllegalStateException(
                    "college with indirizzo " + collegeIndirizzo + " does not exists");
        }
        collegeRepository.deleteCollegeByIndirizzo(collegeIndirizzo);
    }

    @Transactional
    public void updateCollege(String collegeIndirizzo,
                              String nome) {
        College college = collegeRepository.findCollegeByIndirizzo(collegeIndirizzo)
                .orElseThrow(() -> new IllegalStateException(
                        "college with indirizzo " + collegeIndirizzo + " does not exist"));
        if (collegeIndirizzo != null &&
                collegeIndirizzo.length() > 0 &&
                !Objects.equals(college.getIndirizzo(), collegeIndirizzo)) {
            college.setIndirizzo(collegeIndirizzo);
        }
    }
}
