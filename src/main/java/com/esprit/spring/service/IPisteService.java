package com.esprit.spring.service;

import com.esprit.spring.entities.Piste;

import java.util.List;

public interface IPisteService {

    Piste add(Piste cours);

    Piste update(Piste cours);

    List<Piste> getAll();

    Piste getById(Long id);

    boolean deleteById(Long id);
}
