package com.esprit.spring.controllers;

import com.esprit.spring.entities.Abonnement;
import com.esprit.spring.enums.TypeAbonnement;
import com.esprit.spring.service.IAbonnementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("abonnements")
@RequiredArgsConstructor
public class AbonnementController {
    private final IAbonnementService iAbonnementService;

    @GetMapping
    public List<Abonnement> getAbonnements(){
        return iAbonnementService.getAll();
    }

    @GetMapping("{id}")
    public Abonnement getAbonnement(@PathVariable long id){
        return iAbonnementService.getById(id);
    }

    @PostMapping()
    public Abonnement addAbonnement(@RequestBody Abonnement s){
        return iAbonnementService.add(s);
    }


    @PutMapping
    public Abonnement updateAbonnement(@RequestBody Abonnement s){
        return iAbonnementService.update(s);
    }

    @DeleteMapping("{id}")
    public boolean deleteAbonnement(@PathVariable long id){
        return iAbonnementService.deleteById(id);
    }

    @GetMapping("{type}")
    Set<Abonnement> getSubscriptionByType(@PathVariable("type") TypeAbonnement type){
        return iAbonnementService.getSubscriptionByType(type);
    }

    @GetMapping("bydate")
    List <Abonnement> retrieveSubscriptionsByDates(@RequestParam LocalDate startDate , @RequestParam LocalDate endDate){
        return iAbonnementService.retrieveSubscriptionsByDates(startDate,endDate);
    }
}
