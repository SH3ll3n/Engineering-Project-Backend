package com.example.demo.Ragazzo;

import com.example.demo.College.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RagazzoRepository
        extends JpaRepository<Ragazzo, String> {

//  SELECT * FROM guy WHERE email= ?
}
