package com.dclasyc.footballersrestdemo.config;

import com.dclasyc.footballersrestdemo.model.Footballer;
import com.dclasyc.footballersrestdemo.repo.FootballerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class FootballerConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(
//            FootballerRepository repository
//    ){
//        return args -> {
//            Footballer messi = new Footballer(
//                    "Messi",
//                    "Lionel.messi@gmail.com",
//                    "PSG",
//                    LocalDate.of(1989, JUNE,17)
//            );
//
//            Footballer osimhen = new Footballer(
//                    "osimhen",
//                    "victor.osimhen@gmail.com",
//                    "Napoli",
//                    LocalDate.of(1998, JUNE,26)
//            );
//            repository.saveAll(
//                    List.of(messi, osimhen)
//            );
//
//        };

//    }
}
