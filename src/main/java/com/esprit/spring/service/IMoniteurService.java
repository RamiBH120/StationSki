package com.esprit.spring.service;

import com.esprit.spring.entities.Moniteur;
import com.esprit.spring.enums.Support;

import java.util.List;

public interface IMoniteurService {

    Moniteur add(Moniteur cours);

    Moniteur update(Moniteur cours);

    List<Moniteur> getAll();

    Moniteur getById(Long id);

    boolean deleteById(Long id);

    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);

    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support);
}
