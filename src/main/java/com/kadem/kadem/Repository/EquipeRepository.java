package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Equipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipeRepository extends CrudRepository<Equipe, Long> {
    //@Query("select equipe from Equipe equipe join Universite universite on equipe.etudiants member universite.Departments where universite.nomUniv=?1")
    //public Equipe findByNomUniversité(String nom);
}
