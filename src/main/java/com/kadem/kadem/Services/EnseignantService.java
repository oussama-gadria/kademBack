package com.kadem.kadem.Services;

import com.kadem.kadem.Controlleur.UniversiteControlleur;
import com.kadem.kadem.Entities.Enseignant;
import com.kadem.kadem.Entities.Universite;
import com.kadem.kadem.Repository.EnseignantRepository;
import com.kadem.kadem.Repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnseignantService implements EnseignantSerivceInterface{
    @Autowired
    EnseignantRepository enseignantRepository;
    @Autowired
    UniversiteRepository universiteRepository;
    @Override
    public List<Enseignant> retrieveAllEnseignant() {
        return (List<Enseignant>) enseignantRepository.findAll();
    }

    @Override
    public Enseignant addEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @Override
    public Enseignant updateEnseignant(Enseignant enseignant ,Long idE) {
        Enseignant upEnsignant =enseignantRepository.findById(idE).get();
        upEnsignant.setNom_Enseignant(enseignant.getNom_Enseignant());
        upEnsignant.setPrenom_Enseignant(enseignant.getPrenom_Enseignant());
        upEnsignant.setDomaine(enseignant.getDomaine());
        enseignantRepository.save(enseignant);
        return enseignant;
    }

    @Override
    public Enseignant retrieveEnseignant(Long idEnseignant) {
        return enseignantRepository.findById(idEnseignant).get();
    }

    @Override
    public Long deleteEnseignant(Long idEnseignant) {
        enseignantRepository.deleteById(idEnseignant);
        return idEnseignant;
    }

    /*
    @Override
    public void addEnseignantWithUniversite(Long idUniversite, Enseignant enseignant) {
        Universite univ=universiteRepository.findById(idUniversite).get();
        enseignant.setUniversite(univ);
        Enseignant s=enseignantRepository.save(enseignant);
        List<Enseignant> enseignants_univ=univ.getEnseignant();
        enseignants_univ.add(s);
        univ.setEnseignant(enseignants_univ);
        universiteRepository.save(univ);
    }
    */

}