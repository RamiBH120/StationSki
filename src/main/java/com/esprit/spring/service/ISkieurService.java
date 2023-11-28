package com.esprit.spring.service;

import com.esprit.spring.entities.Skieur;
import com.esprit.spring.enums.TypeAbonnement;

import java.util.List;

public interface ISkieurService {

    Skieur add(Skieur cours);

    Skieur update(Skieur cours);

    List<Skieur> getAll();

    Skieur getById(Long id);

    boolean deleteById(Long id);

    Skieur addSkieurAndAssignToCourse(Skieur skieur, Long numCourse);

    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);

    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
}
