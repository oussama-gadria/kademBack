package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Enseignant;
import com.kadem.kadem.ExceptionHandlerForUnivAndEnseignant.InvalidIdException;


import java.util.List;

public interface EnseignantSerivceInterface {
    List<Enseignant> retrieveAllEnseignant();
    Enseignant addEnseignant(Enseignant enseignant);
    Enseignant updateEnseignant(Enseignant enseignant,Long idE);
    Enseignant retrieveEnseignant(Long idEnseignant);
    Long deleteEnseignant(Long idEnseignant);
    Enseignant addEnseignantToModule(Long IdModule,Enseignant enseignant) throws InvalidIdException;
   List<Enseignant> getEnseignantByIdUniversiteandIdDepartementandIdModule(Long idUniversite, Long idDepartement, Long idModule);
    List<Enseignant> triEnseignantBySalary(Long idUniversite, Long idDepartement, Long idModule);



}
