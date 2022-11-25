package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.DetailEquipe;
import com.kadem.kadem.Entities.Equipe;
import com.kadem.kadem.Repository.DetailEquipeRepository;
import com.kadem.kadem.Repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DetailEquipeService implements IDetailEquipeService {
    @Autowired
    private DetailEquipeRepository detailEquipeRepository;
    @Autowired
    private EquipeRepository equipeRepository;
    @Override
    public List<DetailEquipe> getListeDetailEquipes(){
        return (List<DetailEquipe>) detailEquipeRepository.findAll();
    }
    @Override
    public DetailEquipe getDetailEquipeById(int id){
        DetailEquipe DE=detailEquipeRepository.findById(id).get();
        return DE ;
    }
    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe DE){
        return detailEquipeRepository.save(DE);
    }
    @Override
    public DetailEquipe updateDetailEquipe(int id , DetailEquipe DE){
        if(detailEquipeRepository.existsById(id))
        {
        DetailEquipe de1=detailEquipeRepository.findById(id).get();
        de1.setThematique(DE.getThematique());
        de1.setEquipe(DE.getEquipe());
        detailEquipeRepository.save(de1);
        return de1;
        }
        else return null;
    }

    @Override
    public String deleteDetailEquipe(int id) {

        if (detailEquipeRepository.existsById(id)) {
            detailEquipeRepository.deleteById(id);
            return "true";
        }
        else {
            return "false";
        }
    }

    @Override
    public String DetailEquipeWithEquipe(Long IdEquipe, DetailEquipe DE) {
        Equipe equipe=equipeRepository.findById(IdEquipe).get();
        DE.setEquipe(equipe);
        detailEquipeRepository.save(DE);
        return "validée";
    }
}
