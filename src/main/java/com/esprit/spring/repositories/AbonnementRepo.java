package com.esprit.spring.repositories;

import com.esprit.spring.entities.Abonnement;
import com.esprit.spring.entities.Cours;
import com.esprit.spring.enums.TypeAbonnement;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface AbonnementRepo extends CrudRepository<Abonnement,Long> {

    List<Abonnement> findByTypeAbonOrderByDateDebutAsc(TypeAbonnement typeAbonnement);

    List<Abonnement> findByDateDebutAfterAndDateFinBefore(LocalDate dateDebut, LocalDate dateFin);
}
