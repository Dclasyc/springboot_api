package com.dclasyc.footballersrestdemo.footballer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/footballer")
public class FootballerController {
    //This class will have all resources for our API

    //Reference statement to student service
    private final FootballerService footballerService;

    //Generate the constructor of footballerService with Autowired
    @Autowired
    public FootballerController(FootballerService footballerService){
        this.footballerService = footballerService;
    }

    @GetMapping
    public List<Footballer> getFootballers(){
        return footballerService.getFootballers();
    }
}
