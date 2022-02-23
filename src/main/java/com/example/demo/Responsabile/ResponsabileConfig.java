package com.example.demo.Responsabile;

import com.example.demo.Ragazzo.RagazzoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ResponsabileConfig {

    @Bean
    CommandLineRunner commandLineRunnerResponsabile(
            ResponsabileRepository repository) {
        return args -> {
            Responsabile pino = new Responsabile(
                    "pino.mariotto@gmail.com",
                    "Pino",
                    "Mariotto",
                    "Cascata",
                    293748592
            );
            Responsabile marta = new Responsabile(
                    "marta.azzoni@gmail.com",
                    "Marta",
                    "Azzoni",
                    "libellula42",
                    472849503
            );
            repository.saveAll(
                    List.of(pino, marta)
            );
        };
    }
}
