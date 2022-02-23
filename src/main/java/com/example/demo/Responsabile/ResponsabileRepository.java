package com.example.demo.Responsabile;

import com.example.demo.Ragazzo.Ragazzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResponsabileRepository
            extends JpaRepository<Responsabile, String> {
    }