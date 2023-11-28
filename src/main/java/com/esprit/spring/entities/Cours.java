package com.esprit.spring.entities;

import com.esprit.spring.enums.Support;
import com.esprit.spring.enums.TypeCours;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCours;
    private Integer niveau;

    @Enumerated(EnumType.STRING)
    private TypeCours typeCours;

    @Enumerated(EnumType.STRING)
    private Support support;
    private Float prix;
    private Integer creneau;

    @JsonIgnore
    @OneToMany(mappedBy = "cours")
    private Set<Inscription> inscriptions;

}
