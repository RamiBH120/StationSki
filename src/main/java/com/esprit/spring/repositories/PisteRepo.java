package com.esprit.spring.repositories;

import com.esprit.spring.entities.Cours;
import com.esprit.spring.entities.Piste;
import org.springframework.data.repository.CrudRepository;

public interface PisteRepo  extends CrudRepository<Piste,Long> {
}
