package com.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "numSkieur"
)
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur;

    private String nomS;

    private String prenomS;

    private LocalDate dateNaissanceS;

    private String ville;

    @ManyToMany(mappedBy = "skieurs")//si on veut que la table piste gère la relation à travers l'attribut skieurs de la table piste
            //dans ce cas l'entité piste và gérér la relation
            //8 tables pour ce tp(à fàiré)
    Set<Piste> pistes;

    @JsonIgnore
    @OneToMany(mappedBy = "skieur",cascade = CascadeType.ALL)//de pref on impl cascade dans l'entité qui gère la relation pour sauver la jointure avec ses fils
    //pas de sense si on le fait dans la classe fils, dans ce cas le skieur, pr le raison de seulement ajouter l'objet sans faire de join
    private Set<Inscription> inscriptions;

    @OneToOne(cascade = CascadeType.ALL)
    private Abonnement abonnement;

}
