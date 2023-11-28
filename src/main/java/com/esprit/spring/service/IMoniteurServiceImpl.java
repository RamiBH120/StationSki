package com.esprit.spring.service;

import com.esprit.spring.entities.Cours;
import com.esprit.spring.entities.Inscription;
import com.esprit.spring.entities.Moniteur;
import com.esprit.spring.enums.Support;
import com.esprit.spring.repositories.CoursRepo;
import com.esprit.spring.repositories.MoniteurRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class IMoniteurServiceImpl implements IMoniteurService{

    private final MoniteurRepo moniteurRepo;
    private final CoursRepo coursRepo;

    @Override
    public Moniteur add(Moniteur moniteur) {
        return moniteurRepo.save(moniteur);
    }

    @Override
    public Moniteur update(Moniteur moniteur) {
        return moniteurRepo.save(moniteur);
    }

    @Override
    public List<Moniteur> getAll() {
        return (List<Moniteur>) moniteurRepo.findAll();
    }

    @Override
    public Moniteur getById(Long id) {
        return moniteurRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("moniteur not found"));
    }

    @Override
    public boolean deleteById(Long id) {
        moniteurRepo.deleteById(id);
        return !(moniteurRepo.existsById(id));
    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        Cours cours=coursRepo.findById(numCourse).orElseThrow(() -> new EntityNotFoundException("cours not found"));
        Set<Cours> coursSet=moniteur.getCoursSet();
        coursSet.add(cours);
        moniteur.setCoursSet(coursSet);
        return moniteurRepo.save(moniteur);

    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
        Moniteur moniteur=moniteurRepo.findByNumMoniteurAndCoursSetSupport(numInstructor,support);

        List<Integer> numWeeks = new ArrayList<>();
        moniteur.getCoursSet().
                forEach(cours -> cours.getInscriptions().
                        forEach(inscription -> numWeeks.add(inscription.getNumSemaine())));
        return numWeeks;

    }
}
