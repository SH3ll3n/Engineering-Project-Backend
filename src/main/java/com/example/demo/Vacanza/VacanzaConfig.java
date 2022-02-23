package com.example.demo.Vacanza;

import com.example.demo.Gita.Gita;
import com.example.demo.Gita.GitaId;
import com.example.demo.Gita.GitaRepository;
import com.example.demo.Ragazzo.RagazzoRepository;
import com.example.demo.Vacanza.Vacanza;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class VacanzaConfig {

    @Bean
    CommandLineRunner commandLineRunnerVacanza(
            VacanzaRepository repository) {
        return args -> {
            Vacanza francia = new Vacanza(
                    "Parigi",
                    LocalDate.of(2022, Month.APRIL, 5),
                    3,
                    "francese"
            );
            Vacanza spagna = new Vacanza(
                    "Barcellona",
                    LocalDate.of(2021, Month.APRIL, 10),
                    4,
                    "spagnolo"
            );
            Gita parigi = new Gita(
                    new GitaId(
                            "Louvre"
                            ),
                    "visita al Louvre, alla Torre Eiffel e a Notre Dame.",
                    45,
                    10
            );
            Gita barcellona = new Gita(
                    new GitaId(
                            "Sagrada Familia"
                            ),
                    "visita Sagrada Familia, Parco Guell e La Rambla.",
                    38,
                    10
            );
            //salva nel DB
            spagna= repository.saveAndFlush(spagna);
            francia= repository.saveAndFlush(francia);
            //interallaccia gita e vacanza
            parigi.setVacanza(francia);
            barcellona.setVacanza(spagna);
            francia.getGite().add(parigi);
            spagna.getGite().add(barcellona);
            spagna= repository.saveAndFlush(spagna);
            francia= repository.saveAndFlush(francia);
        };
    }
}
