package com.esprit.spring.controllers;

import com.esprit.spring.entities.Moniteur;
import com.esprit.spring.enums.Support;
import com.esprit.spring.service.IMoniteurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("moniteurs")
@RequiredArgsConstructor
public class MoniteurController {
    
    private final IMoniteurService iMoniteurService;

    @GetMapping
    public List<Moniteur> getMoniteurs(){
        return iMoniteurService.getAll();
    }

    @GetMapping("{id}")
    public Moniteur getMoniteur(@PathVariable long id){
        return iMoniteurService.getById(id);
    }

    @PostMapping()
    public Moniteur addMoniteur(@RequestBody Moniteur s){
        return iMoniteurService.add(s);
    }


    @PutMapping
    public Moniteur updateMoniteur(@RequestBody Moniteur s){
        return iMoniteurService.update(s);
    }

    @DeleteMapping("{id}")
    public boolean deleteMoniteur(@PathVariable long id){
        return iMoniteurService.deleteById(id);
    }

    @PostMapping("{numcourse}")
    public Moniteur addInstructorAndAssignToCourse(@RequestBody Moniteur moniteur ,@PathVariable("numcourse") Long numCourse){
        return iMoniteurService.addInstructorAndAssignToCourse(moniteur,numCourse);

    }

    @GetMapping("numWeeks")
    List <Integer > numWeeksCourseOfInstructorBySupport(@RequestParam Long numInstructor , Support support){
        return iMoniteurService.numWeeksCourseOfInstructorBySupport(numInstructor,support);
    }

}
