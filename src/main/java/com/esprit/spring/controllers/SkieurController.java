package com.esprit.spring.controllers;

import com.esprit.spring.entities.Abonnement;
import com.esprit.spring.entities.Skieur;
import com.esprit.spring.enums.TypeAbonnement;
import com.esprit.spring.service.ISkieurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("skieurs")
@RequiredArgsConstructor
public class SkieurController {

    private final ISkieurService iSkieurService;

    @GetMapping
    public List<Skieur> getSkieurs(){
        return iSkieurService.getAll();
    }

    @GetMapping("{id}")
    public Skieur getSkieur(@PathVariable long id){
        return iSkieurService.getById(id);
    }

    @PostMapping()
    public Skieur addSkieur(@RequestBody Skieur s){
        return iSkieurService.add(s);
    }

    @PostMapping("abonnement/{id}")
    public Skieur addAbonnementToSkieur(@RequestBody Abonnement a, @PathVariable Long id){
        Skieur s = iSkieurService.getById(id);
        s.setAbonnement(a);
        return iSkieurService.add(s);
    }


    @PutMapping
    public Skieur updateSkieur(@RequestBody Skieur s){
        return iSkieurService.update(s);
    }

    @DeleteMapping("{id}")
    public boolean deleteSkieur(@PathVariable long id){
        return iSkieurService.deleteById(id);
    }

    @PutMapping("skieurToPiste")
    Skieur assignSkierToPiste(@RequestParam("numSkieur") Long numSkieur ,@RequestParam("numPiste") Long numPiste){
        return iSkieurService.assignSkierToPiste(numSkieur ,numPiste);
    }

    @PostMapping("cours/{numCourse}")
    public Skieur addSkierAndAssignToCourse(@RequestBody Skieur skieur,@PathVariable Long numCourse){
        return iSkieurService.addSkieurAndAssignToCourse(skieur,numCourse);
    }

    @GetMapping("{type}")
    List<Skieur> retrieveSkiersBySubscriptionType(@PathVariable("type") TypeAbonnement typeAbonnement){
        return iSkieurService.retrieveSkiersBySubscriptionType(typeAbonnement);
    }
}
