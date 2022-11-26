package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.DetailEquipe;
import com.kadem.kadem.Entities.Equipe;
import com.kadem.kadem.Repository.DetailEquipeRepository;
import com.kadem.kadem.Repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EquipeService implements IEquipeService {
    @Autowired
    private EquipeRepository equipeRepository;
    @Autowired
    private DetailEquipeRepository detailEquipeRepository;
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





}
