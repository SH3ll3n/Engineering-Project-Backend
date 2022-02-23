package com.example.demo.Famiglia;

import com.example.demo.Ragazzo.RagazzoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class FamigliaConfig {

    @Bean
    CommandLineRunner commandLineRunnerFamiglia(
            FamigliaRepository repository) {
        return args -> {
            Famiglia gianluca = new Famiglia(
                    "Gianluca",
                    "Pietrini",
                    5,
                    3,
                    4,
                    2,
                    20
            );
            repository.saveAll(
                    List.of(gianluca)
            );
        };
    };
}
