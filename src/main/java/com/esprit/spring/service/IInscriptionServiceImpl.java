package com.esprit.spring.service;

import com.esprit.spring.entities.Cours;
import com.esprit.spring.entities.Inscription;
import com.esprit.spring.entities.Skieur;
import com.esprit.spring.repositories.CoursRepo;
import com.esprit.spring.repositories.InscriptionRepo;
import com.esprit.spring.repositories.SkieurRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IInscriptionServiceImpl implements IInscriptionService{

    private final InscriptionRepo inscriptionRepo;

    private final SkieurRepo skieurRepo;

    private final CoursRepo coursRepo;

    @Override
    public Inscription add(Inscription inscription) {
        return inscriptionRepo.save(inscription);
    }

    @Override
    public Inscription update(Inscription inscription) {
        return inscriptionRepo.save(inscription);
    }

    @Override
    public List<Inscription> getAll() {
        return (List<Inscription>) inscriptionRepo.findAll();
    }

    @Override
    public Inscription getById(Long id) {

        return inscriptionRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
    }

    @Override
    public boolean deleteById(Long id) {

        inscriptionRepo.deleteById(id);
        return !(inscriptionRepo.existsById(id));
    }

    @Override
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, long id) {
        Skieur skieur=skieurRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("skieur not found"));

        inscription.setSkieur(skieur);
        return inscriptionRepo.save(inscription);
    }

    @Override
    public Inscription addInscriptionAndAssignToCours(Inscription inscription, long id) {
        Cours cours=coursRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("cours not found"));

        inscription.setCours(cours);
        return inscriptionRepo.save(inscription);
    }

    @Transactional
    @Override
    public Inscription assignInscriptionToCours(long idinscription, long idcours) {
        Inscription inscription=inscriptionRepo.findById(idinscription).orElseThrow(() -> new EntityNotFoundException("inscription not found"));
        Cours cours=coursRepo.findById(idcours).orElseThrow(() -> new EntityNotFoundException("cours not found"));
        inscription.setCours(cours);

        return inscription;
    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {
        Skieur skieur=skieurRepo.findById(numSkieur).orElseThrow(() -> new EntityNotFoundException("skieur not found"));
        Cours cours=coursRepo.findById(numCours).orElseThrow(() -> new EntityNotFoundException("cours not found"));

        if(!cours.getTypeCours().toString().equals("COLLECTIF_ENFANT") && !cours.getTypeCours().toString().equals("COLLECTIF_ADULTE") || cours.getInscriptions().size()<6 ) {
            inscription.setCours(cours);
            if (Period.between(skieur.getDateNaissanceS(), LocalDate.now()).getYears() > 18)
                inscription.setSkieur(skieur);
        }

        return inscriptionRepo.save(inscription);
    }


}
