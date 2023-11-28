package com.esprit.spring.service;

import com.esprit.spring.entities.*;
import com.esprit.spring.enums.TypeAbonnement;
import com.esprit.spring.repositories.CoursRepo;
import com.esprit.spring.repositories.InscriptionRepo;
import com.esprit.spring.repositories.PisteRepo;
import com.esprit.spring.repositories.SkieurRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ISkieurServiceImpl implements ISkieurService{

    private final SkieurRepo skieurRepo;
    private final CoursRepo coursRepo;
    private final InscriptionRepo inscriptionRepo;
    private final PisteRepo pisteRepo;


    @Override
    public Skieur add(Skieur skieur) {
        return skieurRepo.save(skieur);
    }

    @Override
    public Skieur update(Skieur skieur) {
        return skieurRepo.save(skieur);
    }

    @Override
    public List<Skieur> getAll() {
        return (List<Skieur>) skieurRepo.findAll();
    }

    @Override
    public Skieur getById(Long id) {
        return skieurRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
    }

    @Override
    public boolean deleteById(Long id) {

        skieurRepo.deleteById(id);
        return !(skieurRepo.existsById(id));
    }

    @Transactional
    //transactional fonctionne lorsque les objets sont récupérés à partir de la bd(managed ref),on leur modifie,puis on leur sauvegarde,
    //mais si on travail sur un nouveau objet passé en param, qui n'a pas de ref à partir de la bd, donc transactional ne fonctionne pas
    //pareil si on récupère un objet à partir de la bd, mais on le modifie et l'affecte à un nouveau objet(soit instancié ou passé en param)
    //donc transactional ne fonctionne pas dans ces 2 cas
    @Override
    public Skieur addSkieurAndAssignToCourse(Skieur skieur, Long numCourse) {
        //Abonnement abonnement=skieur.getAbonnement(); pas besoin de récuperer l'abonnement parceque skieur implemente cascadetype dans abon one to one
        Inscription inscription=skieur.getInscriptions().stream().findFirst().orElseThrow();
        Cours cours=coursRepo.findById(numCourse).orElseThrow(() -> new EntityNotFoundException("cours not found"));

        inscription.setCours(cours);
        inscription.setSkieur(skieur);

        skieurRepo.save(skieur);
        inscriptionRepo.save(inscription);
        return skieur;
    }

    @Transactional
    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        Skieur skieur=skieurRepo.findById(numSkieur).orElseThrow(() -> new EntityNotFoundException("skieur not found"));
        Piste piste=pisteRepo.findById(numPiste).orElseThrow(() -> new EntityNotFoundException("piste not found"));

        Set<Skieur> skieurSet=piste.getSkieurs();
        skieurSet.add(skieur);
        piste.setSkieurs(skieurSet);
        return skieur;
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        /*List<Skieur> skieurs= (List<Skieur>) skieurRepo.findAll();
        return skieurs.stream().filter(skieur -> skieur.getAbonnement().getTypeAbon().equals(typeAbonnement)).collect(Collectors.toList());*/

        return skieurRepo.findByAbonnement_TypeAbon(typeAbonnement);
    }


}
