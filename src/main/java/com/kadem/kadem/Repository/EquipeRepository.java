package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Equipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipeRepository extends CrudRepository<Equipe, Long> {
    @Query("select equipe from Equipe equipe join Etudiant etudiant on etudiant member equipe.etudiants join Departement departement on etudiant member departement.etudiants join Universite universite on departement member universite.departements where universite.nom_universite=?1")
    public Equipe findByNomUniversité(String nom);
}
