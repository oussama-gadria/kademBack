package com.kadem.kadem.Services;


import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Entities.Enseignant;
import com.kadem.kadem.Entities.Module;
import com.kadem.kadem.Entities.Universite;
import com.kadem.kadem.ExceptionHandlerForUnivAndEnseignant.InvalidIdException;
import com.kadem.kadem.Repository.DepartementRepository;
import com.kadem.kadem.Repository.EnseignantRepository;
import com.kadem.kadem.Repository.ModuleRepository;
import com.kadem.kadem.Repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnseignantService implements EnseignantSerivceInterface {
    @Autowired
    EnseignantRepository enseignantRepository;
    @Autowired
    UniversiteRepository universiteRepository;
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    ModuleRepository moduleRepository;

    ////////////////////////////////////////CRUD///////////////////////////////////////////////////////////
    @Override
    public List<Enseignant> retrieveAllEnseignant() {
        return (List<Enseignant>) enseignantRepository.findAll();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Enseignant addEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Enseignant updateEnseignant(Enseignant enseignant, Long idE) {
        Enseignant upEnsignant = enseignantRepository.findById(idE).get();
        upEnsignant.setNomEnseignant(enseignant.getNomEnseignant());
        upEnsignant.setPrenomEnseignant(enseignant.getPrenomEnseignant());
        upEnsignant.setNomMatiere(enseignant.getNomMatiere());
        upEnsignant.setEmail(enseignant.getEmail());
        upEnsignant.setAge(enseignant.getAge());
        upEnsignant.setSalaire(enseignant.getSalaire());
        upEnsignant.setExperienceParAnnee(enseignant.getExperienceParAnnee());
        upEnsignant.setModule(enseignant.getModule());
        enseignantRepository.save(upEnsignant);
        return enseignant;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Enseignant retrieveEnseignant(Long idEnseignant) {
        return enseignantRepository.findById(idEnseignant).get();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Long deleteEnseignant(Long idEnseignant) {
        enseignantRepository.deleteById(idEnseignant);
        return idEnseignant;
    }

    //////////////////////////////////////////////FONCTION AVANCEE////////////////////////////////////////////////
    @Override
    public Enseignant addEnseignantToModule(Long IdModule, Enseignant enseignant) throws InvalidIdException {
        Module module = moduleRepository.findById(IdModule).get();
        if (module != null) {
            enseignantRepository.save(enseignant);
            if (enseignant.getModule() != null) {
                enseignant.setModule(module);
                enseignantRepository.save(enseignant);

            } else if (enseignant.getModule() == null) {
                Module module1 = module;
                enseignant.setModule(module1);
                enseignantRepository.save(enseignant);

            }
        } else {
            throw new InvalidIdException("Aucun Module existe avec l'Id:" + IdModule);
        }
        return enseignant;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<Enseignant> getEnseignantByIdUniversiteandIdDepartementandIdModule(Long idUniversite, Long idDepartement, Long idModule) {
        return enseignantRepository.getEnseignantByIdUniversiteAndIdDepartementAndIdModule(idUniversite, idDepartement, idModule);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<Enseignant> triEnseignantBySalary(Long idUniversite, Long idDepartement, Long idModule) {
        List<Enseignant> ListEnseignants = enseignantRepository.getEnseignantByIdUniversiteAndIdDepartementAndIdModule(idUniversite, idDepartement, idModule);
        Integer taille = ListEnseignants.size();
        for (Integer i = 1; i < taille; i++) {
            float salaire = ListEnseignants.get(i).getSalaire();
            Integer j = i - 1;
            while (j >= 0 && ListEnseignants.get(j).getSalaire() > salaire) {
                Enseignant e = ListEnseignants.get(j + 1);
                ListEnseignants.set(j + 1, ListEnseignants.get(j));
                ListEnseignants.set(j, e);
                j--;
            }

        }

        return ListEnseignants;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public List<Enseignant> triEnsBySalary() {
        List<Enseignant> ListEnseignants = enseignantRepository.findAll();
        Integer taille = ListEnseignants.size();
        for (Integer i = 1; i < taille; i++) {
            float salaire = ListEnseignants.get(i).getSalaire();
            Integer j = i - 1;
            while (j >= 0 && ListEnseignants.get(j).getSalaire() > salaire) {
                Enseignant e = ListEnseignants.get(j + 1);
                ListEnseignants.set(j + 1, ListEnseignants.get(j));
                ListEnseignants.set(j, e);
                j--;
            }

        }

        return ListEnseignants;

    }
    @Override
    public List<Enseignant> triEnsBySalarycroissant() {
        List<Enseignant> ListEnseignants = enseignantRepository.findAll();
        Integer taille = ListEnseignants.size();
        for (Integer i = 1; i < taille; i++) {
            float salaire = ListEnseignants.get(i).getSalaire();
            Integer j = i - 1;
            while (j >= 0 && ListEnseignants.get(j).getSalaire() < salaire) {
                Enseignant e = ListEnseignants.get(j + 1);
                ListEnseignants.set(j + 1, ListEnseignants.get(j));
                ListEnseignants.set(j, e);
                j--;
            }

        }

        return ListEnseignants;

    }
}
