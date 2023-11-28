package com.esprit.spring.controllers;

import com.esprit.spring.entities.Cours;
import com.esprit.spring.entities.Inscription;
import com.esprit.spring.entities.Skieur;
import com.esprit.spring.service.ICoursService;
import com.esprit.spring.service.IInscriptionService;
import com.esprit.spring.service.ISkieurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inscriptions")
@RequiredArgsConstructor
public class InscriptionController {

    private final IInscriptionService iInscriptionService;

    @GetMapping
    public List<Inscription> getInscriptions(){
        return iInscriptionService.getAll();
    }

    @GetMapping("{id}")
    public Inscription getInscription(@PathVariable long id){
        return iInscriptionService.getById(id);
    }

    @PostMapping()
    public Inscription addInscription(@RequestBody Inscription s){
        return iInscriptionService.add(s);
    }


    @PutMapping
    public Inscription updateInscription(@RequestBody Inscription s){
        return iInscriptionService.update(s);
    }

    @DeleteMapping("{id}")
    public boolean deleteInscription(@PathVariable long id){
        return iInscriptionService.deleteById(id);
    }


    @PostMapping("skieur/{id}")
    public Inscription addRegistrationAndAssignToSkieur(@RequestBody Inscription inscription, @PathVariable long id){
        return iInscriptionService.addInscriptionAndAssignToSkieur(inscription,id);
    }

    @PostMapping("cours/{id}")
    public Inscription addRegistrationAndAssignToCours(@RequestBody Inscription inscription, @PathVariable long id){
        return iInscriptionService.addInscriptionAndAssignToCours(inscription,id);
    }

    @PutMapping("{idinscription}/cours/{idcours}")
    public Inscription assignRegistrationToCours(@PathVariable long idinscription, @PathVariable long idcours){
        return iInscriptionService.assignInscriptionToCours(idinscription,idcours);
    }

    @PostMapping("addToSkieurCours")
    public Inscription addRegistrationAndAssignToSkierAndCourse(@RequestBody Inscription inscription , @RequestParam Long numSkieur ,@RequestParam Long numCours){
        return iInscriptionService.addRegistrationAndAssignToSkierAndCourse(inscription,numSkieur,numCours);
    }
}
