package com.esprit.spring.service;

import com.esprit.spring.entities.Inscription;

import java.util.List;

public interface IInscriptionService {

    Inscription add(Inscription cours);

    Inscription update(Inscription cours);

    List<Inscription> getAll();

    Inscription getById(Long id);

    boolean deleteById(Long id);

    Inscription addInscriptionAndAssignToSkieur(Inscription inscription, long id);

    Inscription addInscriptionAndAssignToCours(Inscription inscription, long id);

    Inscription assignInscriptionToCours(long idinscription, long idcours);

    Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours);
}
