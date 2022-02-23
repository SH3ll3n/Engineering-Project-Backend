package com.example.demo.Ragazzo;

import com.example.demo.Genitore.Genitore;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class RagazzoConfig {

    @Bean
    CommandLineRunner commandLineRunnerRagazzo(
            RagazzoRepository repository) {
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
            Ragazzo mario = new Ragazzo(
                    "mario.rossi@gmail.com",
                    "Mario",
                    "Rossi",
                    LocalDate.of(1999, Month.APRIL, 5),
                    "ViaGennaro22",
                    "helloworld",
                    "342857395",
                    "chitarra", franco
            );

            Ragazzo luigi = new Ragazzo(
                    "luigi.venerdi@gmail.com",
                    "Luigi",
                    "Venerdi",
                    LocalDate.of(1998, Month.MARCH, 5),
                    "ViaGennaro22",
                    "Pattern",
                    "342857353",
                    "nuoto", maria
            );

            repository.saveAll(
                    List.of(mario, luigi)
            );
        };
    }
}
