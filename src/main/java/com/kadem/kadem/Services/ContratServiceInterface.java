package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Contrat;
import com.kadem.kadem.ExceptionHandlingEtudiantContrat.InvalidExceptionEtudiantContrat;

import java.util.Date;
import java.util.List;

public interface ContratServiceInterface {
    /////CRUD
    String addContrat (Contrat C);
    List<Contrat> GetAllContrats();
    Contrat updateContrat (Long Id,Contrat C );
    Contrat GetContratById (Long Id);
    void DeleteContrat(Long Id);

    /////Affecter un contrat à un étudiant en vérifiant que l’étudiant n’a pas dépassé la limite autorisée de 5 contrats actifs.
    Contrat affectContratToEtudiant (Contrat contrat, String nomE,String prenomE, String Email) throws InvalidExceptionEtudiantContrat;

    Contrat affectContratToEtudiantwithId (Contrat contrat,Long idEtudiant) throws InvalidExceptionEtudiantContrat;

    ////afficher les contrats d'un etudiant avec filtrage
    List<Contrat> getALLcontratsByIdEtudiantwithFiltrage(Long idEtudiant, Date dateDebut, Date dateFin, boolean x) throws InvalidExceptionEtudiantContrat ;

    /////afficher les contrats selon l'id de l'etudiant

    List<Contrat> getContratByIdEtudiant (Long idEtudiant);
}
