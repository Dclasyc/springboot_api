package com.dclasyc.footballersrestdemo.footballer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//import static com.sun.beans.introspect.PropertyInfo.Name.required;

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

    //Get Request
    @GetMapping
    public List<Footballer> getFootballers(){
        return footballerService.getFootballers();
    }

    //Post Request
    @PostMapping
    public void registerNewFootballer(@RequestBody Footballer footballer){
        footballerService.addNewFootballer(footballer);
    }

    //Delete Request, pass Id
    @DeleteMapping(path = "{footballerId}")
    public void deleteFootballer(@PathVariable("footballerId") Long footballerId){
        footballerService.deleteFootballer(footballerId);
    }

    //Update Request using Setters to affect db
    @PutMapping(path = "{footballerId}")
    public void updateFootballer(
            @PathVariable("footballerId") Long footballerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
                footballerService.updateFootballer(footballerId, name, email);
            }

}
