package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Contrat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratRepository extends CrudRepository<Contrat,Long> {


     public Contrat findAllByArchive(Boolean archive);

     public Long countByArchiveAndEtudiantIdEtudiant(boolean x,Long idEtudiant);

     @Query("select contrat from Contrat contrat join Etudiant etudiant on contrat member etudiant.contrats where contrat.etudiant.idEtudiant=?1 and contrat.dateDebutContrat >=?2 and contrat.dateFinContrat<=?3 and contrat.archive=?4")
     List<Contrat> filterContratByEtudiant (Long idEtudiant, Date dateDebut, Date dateFin,boolean x);

     List<Contrat> findByEtudiantIdEtudiant(Long idEtudiant);


}
