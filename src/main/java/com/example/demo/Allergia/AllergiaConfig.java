package com.example.demo.Allergia;

import com.example.demo.Ragazzo.Ragazzo;
import com.example.demo.Ragazzo.RagazzoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AllergiaConfig {
    @Bean
    CommandLineRunner commandLineRunnerAllergia(
            AllergiaRepository repository) {
        return args -> {
            Ragazzo mario = new Ragazzo(
                    "mario.rossi@gmail.com",
                    "Mario",
                    "Rossi",
                    LocalDate.of(1999, Month.APRIL, 5),
                    "ViaGennaro22",
                    "helloworld",
                    "342857395",
                    "chitarra"
            );

            Ragazzo luigi = new Ragazzo(
                    "luigi.venerdi@gmail.com",
                    "Luigi",
                    "Venerdi",
                    LocalDate.of(1998, Month.MARCH, 5),
                    "ViaGennaro22",
                    "Pattern",
                    "342857353",
                    "nuoto"
            );
                    Allergia polline = new Allergia(
                            new AllergiaId(
                              "polline"
                            ),
                    "spray", mario
            );
            Allergia cioccolata = new Allergia(
                    new AllergiaId(
                            "cioccolata"
                    ),
                    "ridurre", luigi
            );
            repository.saveAll(
                    List.of(polline, cioccolata)
            );
        };
    }
}