package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.BLOC;
import com.kadem.kadem.Entities.Club;
import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Entities.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends CrudRepository<Module,Long> {
    public Module findByNomModule(String nomModule);

    @Query("select club from Club club join Etudiant etudiant on club member etudiant.clubs join Departement  departement on etudiant member departement.etudiants join Universite universite on departement member universite.departements where universite.nom_universite=?1 and departement.nomDepart=?2 ")
    public List<Club> FindClubByDepAndUnivName(String nomUniv, String nomDepart);
}
