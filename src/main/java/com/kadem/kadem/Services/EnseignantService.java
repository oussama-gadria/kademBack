package com.kadem.kadem.Services;


import com.kadem.kadem.Entities.Enseignant;
import com.kadem.kadem.Entities.Universite;
import com.kadem.kadem.ExceptionHandlerForUnivAndEnseignant.InvalidNameException;
import com.kadem.kadem.Repository.DepartementRepository;
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
    @Autowired
    DepartementRepository departementRepository;
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
        upEnsignant.setNomMatiere(enseignant.getNomMatiere());
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
    public Enseignant addEnseignantWithUniversite(String nomUniversite, Enseignant enseignant) throws InvalidNameException {
        Universite univ=universiteRepository.findByNomUniversite(nomUniversite);
        if (univ!=null) {
        enseignant.setUniversite(univ);
        enseignantRepository.save(enseignant);
        return  enseignant;
        }
        else {
            throw new InvalidNameException("universite "+nomUniversite+" n'existe pas ");
        }
   }

    @Override
    public List<Enseignant> getEnseignantByNomUniversite(String nomUniversite) {
        return enseignantRepository.getEnseignantByNomUniversite(nomUniversite);
    }
    //////////////////fonction a completer apres l'ajout de entite module et leur relation ///////////////////////
    /*
    @Override
    public List<Enseignant> getEnseignantByIdUniversiteandIdDepartementandIdModule(Long idUniversite,Long idEnseigenement,Long idDepartement,Long idModule) {
        return enseignantRepository.getEnseignantByNomUniversite(idUniversite,idEnseigenement,idDepartement,idModule);
    }
    */
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<Enseignant> triEnseignantBySalary(Long idUniversite) {
        Universite univ=universiteRepository.findById(idUniversite).get();
        List<Enseignant> ListEnseignants=univ.getEnseignant();
        Integer taille=ListEnseignants.size();
        for (Integer i=1 ;i<taille;i++)
        {
           float salaire=ListEnseignants.get(i).getSalaire();
           Integer j=i-1;
            while(j >= 0 && ListEnseignants.get(j).getSalaire() > salaire)
            {
                ListEnseignants.set(j+1,ListEnseignants.get(j));
                j--;
            }
            ListEnseignants.get(j+1).setSalaire(salaire);
        }

        return ListEnseignants;
    }
    //////////////////fonction a completer apres l'ajout de entite module et leur relation ///////////////////////
    /*
    @Override
    public List<Enseignant> triEnseignantBySalaryByUniversiteAndDepartementAndModule(Long idUniversite,Long idDepartement,Long idModule,Long idEnseignant) {
        Universite univ=universiteRepository.findById(idUniversite).get();
        List<Departement> ListDepartement=univ.getDepartements();
       Departement depart=departementRepository.findById(idDepartement).get();
       List<Moduls> ListModule=depart.getModuls();
       moduls=modulsRepository.findById(idModule);


        List<Enseignant> ListEnseignants=moduls.getEnseignant();
        Integer taille=ListEnseignants.size();
        for (Integer i=1 ;i<taille;i++)
        {
            float salaire=ListEnseignants.get(i).getSalaire();
            Integer j=i-1;
            while(j >= 0 && ListEnseignants.get(j).getSalaire() > salaire)
            {
                ListEnseignants.set(j+1,ListEnseignants.get(j));
                j--;
            }
            ListEnseignants.get(j+1).setSalaire(salaire);
        }

        return ListEnseignants;
    }

   */
}
