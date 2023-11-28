package com.esprit.spring.controllers;

import com.esprit.spring.entities.Cours;
import com.esprit.spring.service.ICoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cours")
@RequiredArgsConstructor
public class CoursController {
    
    private final ICoursService iCoursService;

    @GetMapping
    public List<Cours> getCourses(){
        return iCoursService.getAll();
    }

    @GetMapping("{id}")
    public Cours getCours(@PathVariable long id){
        return iCoursService.getById(id);
    }

    @PostMapping()
    public Cours addCours(@RequestBody Cours s){
        return iCoursService.add(s);
    }


    @PutMapping
    public Cours updateCours(@RequestBody Cours s){
        return iCoursService.update(s);
    }

    @DeleteMapping("{id}")
    public boolean deleteCours(@PathVariable long id){
        return iCoursService.deleteById(id);
    }
}
