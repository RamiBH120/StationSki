package com.esprit.spring.service;

import com.esprit.spring.entities.Cours;
import com.esprit.spring.repositories.CoursRepo;

import java.util.List;

public interface ICoursService {

    Cours add(Cours cours);

    Cours update(Cours cours);

    List<Cours> getAll();

    Cours getById(Long id);

    boolean deleteById(Long id);


}
