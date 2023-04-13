package com.dclasyc.footballersrestdemo.footballer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Jpa repository is given params object class and id to work with
@Repository
public interface FootballerRepository
        extends JpaRepository<Footballer, Long> {

}
