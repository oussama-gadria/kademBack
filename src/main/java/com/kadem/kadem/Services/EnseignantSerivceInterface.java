package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Enseignant;


import java.util.List;

public interface EnseignantSerivceInterface {
    List<Enseignant> retrieveAllEnseignant();
    Enseignant addEnseignant(Enseignant enseignant);
    Enseignant updateEnseignant(Enseignant enseignant,Long idE);
    Enseignant retrieveEnseignant(Long idEnseignant);
    Long deleteEnseignant(Long idEnseignant);
}
