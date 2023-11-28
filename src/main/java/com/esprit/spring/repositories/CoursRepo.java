package com.esprit.spring.repositories;

import com.esprit.spring.entities.Cours;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursRepo extends CrudRepository<Cours,Long> {

    @Query(value = "SELECT *" +
            " FROM cours c" +
            " JOIN moniteur_cours_set mc ON c.num_cours=mc.cours_set_num_cours " +
            "JOIN moniteur m on m.num_moniteur=mc.moniteur_num_moniteur " +
            "WHERE m.nomm = :name ",nativeQuery = true) //native va conserver la forme intiale de la requête(désactiver le jpql)
    List<Cours> getCoursByMoniteurSql(@Param("name") String name);

    @Query(value = "SELECT c " +
            " FROM Cours c" +
            " JOIN Moniteur m ON c member m.coursSet " + //on cherche si le cours c existe dans la liste des cours associée au moniteur
            "WHERE m.nomM = :name ") //jpql intéragit avec les entités directement
    List<Cours> getCoursByMoniteurJpql(@Param("name") String name);
}
