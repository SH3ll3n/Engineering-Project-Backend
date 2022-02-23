package com.example.demo.College;

import com.example.demo.Ragazzo.RagazzoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CollegeConfig {

    @Bean
    CommandLineRunner commandLineRunnerCollege(
            CollegeRepository repository) {
        return args -> {

            College pineta = new College(
                    "lama12",
                    "Pineta",
                    "pallavolo",
                    "sport per gruppo."
            );

            College sassuolo = new College(
                    "farinelli",
                    "Sassuolo",
                    "ginnastica",
                    "stretching e molto altro"
            );
            repository.saveAll(
                    List.of(pineta, sassuolo)
            );
        };
    }
}
