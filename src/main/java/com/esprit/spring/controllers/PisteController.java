package com.esprit.spring.controllers;

import com.esprit.spring.entities.Piste;
import com.esprit.spring.service.IPisteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pistes")
@RequiredArgsConstructor
public class PisteController {
    
    private final IPisteService iPisteService;

    @GetMapping
    public List<Piste> getPistes(){
        return iPisteService.getAll();
    }

    @GetMapping("{id}")
    public Piste getPiste(@PathVariable long id){
        return iPisteService.getById(id);
    }

    @PostMapping()
    public Piste addPiste(@RequestBody Piste s){
        return iPisteService.add(s);
    }


    @PutMapping
    public Piste updatePiste(@RequestBody Piste s){
        return iPisteService.update(s);
    }

    @DeleteMapping("{id}")
    public boolean deletePiste(@PathVariable long id){
        return iPisteService.deleteById(id);
    }
}
