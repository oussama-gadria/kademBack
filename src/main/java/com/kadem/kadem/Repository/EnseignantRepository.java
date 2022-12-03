package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Enseignant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnseignantRepository extends CrudRepository<Enseignant,Long>{
@Query("select enseignant from Enseignant enseignant join Module module on enseignant member module.listEnseignant join Departement departement on module member departement.modules join Universite universite on departement member universite.departements where departement.idDepart=?1 and universite.idUniversite=?2 and module.idModule=?3")
public List<Enseignant> getEnseignantByIdUniversiteAndIdUnivAndIdModule(Long idUniversite, Long idDepartement, Long idModule);

}

