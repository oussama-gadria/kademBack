package com.kadem.kadem.Services;

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
        upEnsignant.setNomEnseignant(enseignant.getNomEnseignant());
        upEnsignant.setPrenomEnseignant(enseignant.getPrenomEnseignant());
        upEnsignant.setNomDepartement(enseignant.getNomDepartement());
        upEnsignant.setSalaire(enseignant.getSalaire());
        upEnsignant.setExperienceParAnnee(enseignant.getExperienceParAnnee());
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


    @Override
    public Enseignant addEnseignantWithUniversite(String nomUniversite, Enseignant enseignant) {
        Universite univ=universiteRepository.findByNomUniversite(nomUniversite);
        if (univ!=null)
        {
        enseignant.setUniversite(univ);
        enseignantRepository.save(enseignant);
        return  enseignant;
    }
        else
        {
            return null;
        }



   }

    @Override
    public List<Enseignant> getEnseignantByNomUniversite(String nomUniversite) {
        return enseignantRepository.getEnseignantByNomUniversite(nomUniversite);
    }
}
