package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Enseignant;
import com.kadem.kadem.ExceptionHandlerForUnivAndEnseignant.InvalidNameException;


import java.util.List;

public interface EnseignantSerivceInterface {
    List<Enseignant> retrieveAllEnseignant();
    Enseignant addEnseignant(Enseignant enseignant);
    Enseignant updateEnseignant(Enseignant enseignant,Long idE);
    Enseignant retrieveEnseignant(Long idEnseignant);
    Long deleteEnseignant(Long idEnseignant);
    Enseignant addEnseignantWithUniversite(String nomUniversite,Enseignant enseignant) throws InvalidNameException;
    List<Enseignant> getEnseignantByNomUniversite(String nomUniversite);
    List<Enseignant> triEnseignantBySalary(Long idUniversite);
    /* List<Enseignant> getEnseignantByIdUniversiteandIdDepartementandIdModule(Long idUniversite,Long idDepartement,Long idModule);*/
    /* List<Enseignant> triEnseignantBySalaryByUniversiteAndDepartementAndModule(Long idUniversite,Long idDepartement,Long idModule,Long idEnseignant);*/

}
