package com.example.demo.Genitore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GenitoreConfig {

    @Bean
    CommandLineRunner commandLineRunnerGenitore(
            GenitoreRepository repository) {
        return args -> {
            Genitore franco = new Genitore(
                    "franco.rossi@gmail.com",
                    "Franco",
                    "Rossi",
                    "342857445"
            );
            Genitore maria = new Genitore(
                    "maria.venerdi@gmail.com",
                    "Maria",
                    "Venerdi",
                    "342257353"
            );
            repository.saveAll(
                    List.of(franco, maria)
            );
        };
    }
}
