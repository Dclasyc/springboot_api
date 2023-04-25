package com.dclasyc.footballersrestdemo.service;

import com.dclasyc.footballersrestdemo.model.Footballer;
import com.dclasyc.footballersrestdemo.repo.FootballerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FootballerService {
    //Create dynamic list of new footballer
    private final FootballerRepository footballerRepository;
    @Autowired
    public FootballerService(FootballerRepository footballerRepository) {
        this.footballerRepository = footballerRepository;
    }

    //Get footballer Method
    public List<Footballer> getFootballers() {
        return footballerRepository.findAll();
    }
    //Post Footballer Method
    public Footballer addNewFootballer(Footballer footballer) {
        //Check if email is available for new user
//        Optional<Footballer> footballerOptional =
//        footballerRepository.findFootballerByEmail(footballer.getEmail());
//        if(footballerOptional.isPresent()){
//            throw new IllegalStateException("This email is taken, try another");
//        }
        return footballerRepository.save(footballer);
    }

    public void deleteFootballer(Long footballerId) {
        boolean exists = footballerRepository.existsById(footballerId);
        if(!exists){
            throw new IllegalStateException(
                    "Footballer with Id "+footballerId+" does not exist"
            );
        }
        footballerRepository.deleteById(footballerId);
    }
    @Transactional
    public void updateFootballer(Long footballerId,
                                 String name,
                                 String email) {
        Footballer footballer = footballerRepository.findById(footballerId)
                .orElseThrow(() -> new  IllegalStateException(
                   "Footballer with Id "+footballerId+" does not exist"
                ));
        if(name != null && name.length() > 0
                && !Objects.equals(footballer.getName(), name)){
            footballer.setName(name);
        }
        if(email != null && email.length() > 0
                && !Objects.equals(footballer.getEmail(), email)){
                //Check if email is taken
            Optional<Footballer> footballerOptional = footballerRepository
                    .findFootballerByEmail(email);
                if(footballerOptional.isPresent()){
                    throw new IllegalStateException(
                        "This email is taken, try another");
                }
                //Set Footballer email after checks
            footballer.setEmail(email);
        }
    }
}
