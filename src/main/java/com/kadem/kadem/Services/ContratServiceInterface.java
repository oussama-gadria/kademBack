package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Contrat;

import java.util.Date;
import java.util.List;

public interface ContratServiceInterface {
    /////CRUD
    String addContrat (Contrat C);
    List<Contrat> GetAllContrats();
    Contrat updateContrat (Long Id,Contrat C );
    Contrat GetContratById (Long Id);
    void DeleteContrat(Long Id);


    Contrat affectContratToEtudiant (Contrat contrat, String nomE,String prenomE, String Email);

    List<Contrat> getALLcontratsByIdEtudiant(Long idEtudiant, Date dateDebut, Date dateFin, boolean x);
}
