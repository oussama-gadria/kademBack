package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Contrat;
import com.kadem.kadem.Entities.Etudiant;

import java.util.List;

public interface EtudiantServiceInterface {


    String addEtudiant (Etudiant E);
    List<Etudiant> GetAllEtudiants();
    Etudiant updateEtudiant (Long Id,Etudiant E );
    Etudiant GetEtudiantById (Long Id);
    void DeleteEtudiant(Long Id);

}
