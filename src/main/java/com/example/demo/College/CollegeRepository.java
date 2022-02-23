package com.example.demo.College;

import com.example.demo.Allergia.Allergia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CollegeRepository
        extends JpaRepository<College, String> {

    boolean existsCollegeByIndirizzo(String collegeIndirizzo);

    void deleteCollegeByIndirizzo(String collegeIndirizzo);

    Optional<College> findCollegeByIndirizzo(String collegeIndirizzo);
}
