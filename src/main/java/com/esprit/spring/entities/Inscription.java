package com.esprit.spring.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long numInscription;
    private Integer numSemaine;

    @ManyToOne
    private Cours cours;

    @ManyToOne
    private Skieur skieur;
}
