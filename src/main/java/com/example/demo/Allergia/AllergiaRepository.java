package com.example.demo.Allergia;

import com.example.demo.Ragazzo.Ragazzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AllergiaRepository
    extends JpaRepository<Allergia, AllergiaId>  {
        Optional<Allergia> findAllergiaById_Nome(String nome);
    }

