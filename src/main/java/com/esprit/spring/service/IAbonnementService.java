package com.esprit.spring.service;

import com.esprit.spring.entities.Abonnement;
import com.esprit.spring.enums.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IAbonnementService {

    Abonnement add(Abonnement cours);

    Abonnement update(Abonnement cours);

    List<Abonnement> getAll();

    Abonnement getById(Long id);

    boolean deleteById(Long id);

    Set<Abonnement> getSubscriptionByType(TypeAbonnement type);

    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
}
