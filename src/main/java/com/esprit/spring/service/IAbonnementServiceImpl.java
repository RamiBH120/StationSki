package com.esprit.spring.service;

import com.esprit.spring.entities.Abonnement;
import com.esprit.spring.enums.TypeAbonnement;
import com.esprit.spring.repositories.AbonnementRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IAbonnementServiceImpl implements IAbonnementService{
    
    private final AbonnementRepo abonnementRepo;
    
    public IAbonnementServiceImpl(AbonnementRepo abonnementRepo){
        this.abonnementRepo=abonnementRepo;
    }
    
    @Override
    public Abonnement add(Abonnement abonnement) {
        return abonnementRepo.save(abonnement);
    }

    @Override
    public Abonnement update(Abonnement abonnement) {
        return abonnementRepo.save(abonnement);
    }

    @Override
    public List<Abonnement> getAll() {
        return (List<Abonnement>) abonnementRepo.findAll();
    }

    @Override
    public Abonnement getById(Long id) {

        return abonnementRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
    }

    @Override
    public boolean deleteById(Long id) {

        abonnementRepo.deleteById(id);
        return !(abonnementRepo.existsById(id));
    }

    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        /*Set<Abonnement> abonnements= (Set<Abonnement>) abonnementRepo.findAll();
        abonnements.stream().toList().sort(Comparator.comparing(Abonnement::getDateDebut));
        return abonnements.stream().filter(abonnement -> abonnement.getTypeAbon().equals(type)).collect(Collectors.toSet());*/

        return (Set<Abonnement>) abonnementRepo.findByTypeAbonOrderByDateDebutAsc(type);
    }
    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        /*List<Abonnement> abonnements= (List<Abonnement>) abonnementRepo.findAll();
        return abonnements.stream().filter(abonnement -> abonnement.getDateDebut().isAfter(startDate) && abonnement.getDateFin().isBefore(endDate)).toList();*/

        return abonnementRepo.findByDateDebutAfterAndDateFinBefore(startDate,endDate);
    }
}
