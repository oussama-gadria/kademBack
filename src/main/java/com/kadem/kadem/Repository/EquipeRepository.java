package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Equipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipeRepository extends CrudRepository<Equipe, Long> {
    //@Query("select count(equipe.etudiants.etudiant) from Equipe equipe join Etudiant etudiant on etudiant member equipe.etudiants where equipe.idEquipe=?1 and equipe.etudiants.etudiant.option=?2")
    //public int getNbEtudiantsInEquipeWithOption(Long idEquipe, String option);

    //@Query("select count(equipe.etudiants) from Equipe equipe join Departement department on equipe.etudiants member department.etudiants where equipe.idEquipe=?1 and department.nomDepart=?2")
    //public int getNbEtudiantsInEquipeWithNomDepartement(Long idEquipe, String nomDepartement);

    //@Query("select contrat from Contrat contrat join Universite universite on contrat.etudiant.department member universite.Departments where universite.idUniv=?1")
    //public List<Contrat> getContratByuniversite(Long idUniv);

}
