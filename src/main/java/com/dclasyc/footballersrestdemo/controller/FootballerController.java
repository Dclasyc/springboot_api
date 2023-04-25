package com.dclasyc.footballersrestdemo.controller;

import com.dclasyc.footballersrestdemo.model.Footballer;
import com.dclasyc.footballersrestdemo.service.FootballerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

//import static com.sun.beans.introspect.PropertyInfo.Name.required;

@RestController
@RequestMapping(path = "/")
public class FootballerController {
    //This class will have all resources for our API

    //Reference statement to student service
    private final FootballerService footballerService;

    //Generate the constructor of footballerService with Autowired
    @Autowired
    public FootballerController(FootballerService footballerService){
        this.footballerService = footballerService;
    }

    //Get Request
    @GetMapping
    public ResponseEntity getFootballers(){
        var list=footballerService.getFootballers();
        if(list.isEmpty()){
            return new ResponseEntity<>("No footballer found",HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(list);
    }

    //Post Request
    @PostMapping
    public ResponseEntity registerNewFootballer(@RequestBody Footballer footballer){
        return new ResponseEntity(footballerService.addNewFootballer(footballer), HttpStatus.CREATED);
    }

    //Delete Request, pass Id
    @DeleteMapping(path = "{id}")
    public void deleteFootballer(@PathVariable("id") Long footballerId){
        footballerService.deleteFootballer(footballerId);
    }

    //Update Request using Setters to affect db
    @PutMapping(path = "{id}")
    public void updateFootballer(
            @PathVariable("id") Long footballerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
                footballerService.updateFootballer(footballerId, name, email);
            }

}
