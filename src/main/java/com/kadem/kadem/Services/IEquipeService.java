package com.kadem.kadem.Services;



import com.kadem.kadem.Entities.Equipe;
import com.kadem.kadem.ExceptionHandling.InvalidIdException;

import java.util.List;

public interface IEquipeService {
    public List<Equipe> getListeEquipes();
    public Equipe getEquipeById(Long id);
    public Equipe addEquipe(Equipe E);
    public Equipe updateEquipe(Long id , Equipe E);
    public String deleteEquipe(Long id);
    public Equipe addEquipeWithDetailEquipe(int IdDE, Equipe E);
    public Equipe assignEtudiantToEquipe(String prenom, String nom,Long idEquipe);
    public Equipe getEquipeByNomUniversite(String nom);
    //public List<Equipe> triEquipeByScore(Long idEquipe);

    public Equipe assignResponsableToEquipe(Long idEnseignant,Long idEquipe) throws InvalidIdException;


}
