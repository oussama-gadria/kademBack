package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Contrat;

import java.util.List;

public interface ContratServiceInterface {
    String addContrat (Contrat C);
    List<Contrat> GetAllContrats();
    Contrat updateContrat (Long Id,Contrat C );
    Contrat GetContratById (Long Id);
    void DeleteContrat(Long Id);

    /////Affecter un contrat à un étudiant en vérifiant que l’étudiant n’a pas dépassé la limite autorisée de 5 contrats actifs.
    Contrat affectContratToEtudiant (Contrat C, String nomE,String prenomE);
}
