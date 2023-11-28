package com.esprit.spring.service;

import com.esprit.spring.entities.Cours;
import com.esprit.spring.repositories.CoursRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICoursServiceImpl implements ICoursService{

    //@Autowired
    private final CoursRepo coursRepo;//injecter une implémentation de l'interface coursrepo dans cet attribut, à partir du spring ioc container

    public ICoursServiceImpl(CoursRepo coursRepo){
        this.coursRepo=coursRepo;
    }

    @Override
    public Cours add(Cours cours) {
        return coursRepo.save(cours);
    }

    @Override
    public Cours update(Cours cours) {
        return coursRepo.save(cours);
    }

    @Override
    public List<Cours> getAll() {
        return (List<Cours>) coursRepo.findAll();
    }

    @Override
    public Cours getById(Long id) {
        return coursRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
    }

    @Override
    public boolean deleteById(Long id) {

        coursRepo.deleteById(id);
        return !(coursRepo.existsById(id));
    }
}
