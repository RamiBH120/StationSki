package com.esprit.spring.repositories;

import com.esprit.spring.entities.Cours;
import com.esprit.spring.entities.Inscription;
import org.springframework.data.repository.CrudRepository;

public interface InscriptionRepo  extends CrudRepository<Inscription,Long> {
}
