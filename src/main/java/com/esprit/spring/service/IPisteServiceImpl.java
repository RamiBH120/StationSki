package com.esprit.spring.service;

import com.esprit.spring.entities.Piste;
import com.esprit.spring.repositories.PisteRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IPisteServiceImpl implements IPisteService{
    
    private final PisteRepo pisteRepo;
    
    public IPisteServiceImpl(PisteRepo pisteRepo){
        this.pisteRepo=pisteRepo;
    }
    
    @Override
    public Piste add(Piste piste) {
        return pisteRepo.save(piste);
    }

    @Override
    public Piste update(Piste piste) {
        return pisteRepo.save(piste);
    }

    @Override
    public List<Piste> getAll() {
        log.info("bonjour!");
        return (List<Piste>) pisteRepo.findAll();
    }

    @Override
    public Piste getById(Long id) {
        return pisteRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
    }

    @Override
    public boolean deleteById(Long id) {
        pisteRepo.deleteById(id);
        return !(pisteRepo.existsById(id));
    }
}
