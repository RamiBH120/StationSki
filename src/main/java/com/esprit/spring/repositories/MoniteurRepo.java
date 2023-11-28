package com.esprit.spring.repositories;

import com.esprit.spring.entities.Cours;
import com.esprit.spring.entities.Moniteur;
import com.esprit.spring.enums.Support;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MoniteurRepo  extends CrudRepository<Moniteur,Long> {

    Moniteur findByNumMoniteurAndCoursSetSupport(Long numMoniteur, Support coursSet_support);
}
