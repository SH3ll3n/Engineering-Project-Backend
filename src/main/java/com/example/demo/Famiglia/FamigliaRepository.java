package com.example.demo.Famiglia;

import com.example.demo.Ragazzo.Ragazzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FamigliaRepository
        extends JpaRepository<Famiglia, String>  {

}
