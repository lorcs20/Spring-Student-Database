package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    //GET
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
            Student lorcan = new Student(16422524, "Lorcan Creedon", LocalDate.of(1998, MARCH, 31), "lorcancreedon1@gmail.com");
            Student sadhbh = new Student("Sadhbh Baumann", LocalDate.of(1999, JULY, 23), "S.BAUMANN1@gmail.com");
            repository.saveAll(List.of(lorcan, sadhbh));
        };
    }
}
