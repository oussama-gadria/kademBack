package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Enseignant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnseignantRepository extends CrudRepository<Enseignant,Long>{
@Query("select enseignant from Enseignant enseignant join Module module on enseignant member module.listEnseignant join Departement departement on module member departement.modules join Universite universite on departement member universite.departements where (universite.idUniversite=?1 and departement.idDepart=?2 and  module.idModule=?3)")
public List<Enseignant> getEnseignantByIdUniversiteAndIdDepartementAndIdModule(Long idUniversite, Long idDepartement, Long idModule);
    List<Enseignant> findAll();
}

