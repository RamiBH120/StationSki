package com.esprit.spring.repositories;

import com.esprit.spring.entities.Cours;
import com.esprit.spring.entities.Skieur;
import com.esprit.spring.enums.Couleur;
import com.esprit.spring.enums.Support;
import com.esprit.spring.enums.TypeAbonnement;
import com.esprit.spring.enums.TypeCours;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkieurRepo  extends CrudRepository<Skieur,Long> {

    List<Skieur> findByAbonnement_TypeAbon(TypeAbonnement abonnement_typeAbon);

    List<Skieur> findByAbonnement_TypeAbonAndPistesCouleurAndInscriptionsCoursSupportAndInscriptionsCoursTypeCours(TypeAbonnement abonnement_typeAbon, Couleur pistes_couleur, Support inscriptions_cours_support, TypeCours inscriptions_cours_typeCours);

    @Query(value = "SELECT * " +
            "FROM skieur s " +
            "JOIN inscription i ON s.num_skieur=i.skieur_num_skieur " +
            "JOIN moniteur_cours_set mc ON i.cours_num_cours=mc.cours_set_num_cours" +
            "JOIN moniteur m on m.num_moniteur=mc.moniteur_num_moniteur" +
            "WHERE m.nomm = :name ",nativeQuery = true)
    List<Skieur> getSkieurByNomMoniteurSql(@Param("name") String name);

    @Query(value = "SELECT i.skieur " +
            "FROM Inscription i " +
            "JOIN Moniteur m on i.cours member m.coursSet " +
            "WHERE m.nomM = :name") //order by nbr piste skieurs
    List<Skieur> getSkieurByNomMoniteurJpql(@Param("name") String name);

    @Query(value = "SELECT i.skieur " +
            "FROM Inscription i " +
            "JOIN Moniteur m on i.cours member m.coursSet " +
            "WHERE m.nomM = :name order by SIZE(i.skieur.pistes) ") //order by nbr piste skieurs
    List<Skieur> getSkieurByNomMoniteurOrderByPisteJpql(@Param("name") String name);
}
