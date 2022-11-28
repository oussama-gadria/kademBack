package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.DetailEquipe;
import com.kadem.kadem.Entities.Equipe;
import com.kadem.kadem.Entities.Etudiant;
import com.kadem.kadem.Repository.DetailEquipeRepository;
import com.kadem.kadem.Repository.EquipeRepository;
import com.kadem.kadem.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EquipeService implements IEquipeService {
    @Autowired
    private EquipeRepository equipeRepository;
    @Autowired
    private DetailEquipeRepository detailEquipeRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Override
    public List<Equipe> getListeEquipes(){
        return (List<Equipe>) equipeRepository.findAll();
    }
    @Override
    public Equipe getEquipeById(Long id){
        Equipe E=equipeRepository.findById(id).get();
        return E ;
    }
    @Override
    public Equipe addEquipe(Equipe E){
        return equipeRepository.save(E);
    }
    @Override
    public Equipe updateEquipe(Long id, Equipe E) {
        if(equipeRepository.existsById(id))
        {
        Equipe e1=equipeRepository.findById(id).get();
        e1.setNomEquipe(E.getNomEquipe());
        e1.setNiveau(E.getNiveau());
        equipeRepository.save(e1);
        return e1;
        }
        else return null;
    }

    @Override
    public String deleteEquipe(Long id) {

        if (equipeRepository.existsById(id)) {
            equipeRepository.deleteById(id);
            return "true";
        }
        else {
            return "false";
        }
    }

    @Override
    public Equipe addEquipeWithDetailEquipe(int IdDE, Equipe E){
        DetailEquipe detailEquipe=detailEquipeRepository.findById(IdDE).get();
        E.setDetailEquipe(detailEquipe);
        equipeRepository.save(E);
        return E;
    }

    @Override
    public Equipe assignEtudiantToEquipe(String prenom, String nom, Long idEquipe) {
        Etudiant etudiant=etudiantRepository.getEtudiantByNomAndPrenom(prenom,nom);
        Equipe equipe=equipeRepository.findById(idEquipe).get();
        List<Etudiant> etudiants=equipe.getEtudiants();
        etudiants.add(etudiant);
        equipeRepository.save(equipe);
        return equipe;
    }

   // @Override
    public Equipe getEquipeByNomUniversite(String nom) {
        //Equipe E=equipeRepository.findByNomUniversité(nom);
        return null;
    }


}
