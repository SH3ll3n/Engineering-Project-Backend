package com.example.demo.Genitore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenitoreRepository
   extends JpaRepository<Genitore, String>  {

        Optional<Genitore> findGenitoreByEmail(String email);

        boolean existsByEmail(String email);

        void deleteByEmail(String email);
}
