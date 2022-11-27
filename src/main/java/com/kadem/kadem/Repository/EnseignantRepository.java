package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Enseignant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantRepository extends CrudRepository<Enseignant,Long>{
@Query("select enseignant from Enseignant enseignant join Universite universite on enseignant member universite.enseignant where universite.nomUniversite=?1")
    public List<Enseignant> getEnseignantByNomUniversite(String nomUniversite);
}
