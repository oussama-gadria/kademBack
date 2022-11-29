package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Contrat;
import com.kadem.kadem.Entities.Etudiant;

import java.util.List;

public interface EtudiantServiceInterface {


    ////CRUD ETUDIANT
    String addEtudiant (Etudiant E);
    List<Etudiant> GetAllEtudiants();
    Etudiant updateEtudiant (Long Id,Etudiant E );
    Etudiant GetEtudiantById (Long Id);
    void DeleteEtudiant(Long Id);

    /////affecter un étudiant à un département(id Depart)
    void assignEtudiantToDepartement (Long etudiantId, Long departementId);

    ////affecter un etudiant à un departement (nom depart)
    ///Etudiant assignEtudiantToDepartementWithNomD (Etudiant etudiant, String departement);


    //ajouter et affecter un étudiant à une équipe et un contrat en utilisant une seule méthode
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe);
}
