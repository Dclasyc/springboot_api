package com.dclasyc.footballersrestdemo.footballer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class FootballerService {
    //Create dynamic list of new footballer
    private final FootballerRepository footballerRepository;
    @Autowired
    public FootballerService(FootballerRepository footballerRepository) {
        this.footballerRepository = footballerRepository;
    }

    public List<Footballer> getFootballers() {
        return footballerRepository.findAll();
    }
}
