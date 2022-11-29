package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Contrat;
import com.kadem.kadem.Entities.Etudiant;
import com.kadem.kadem.Repository.ContratRepository;
import com.kadem.kadem.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratService implements ContratServiceInterface{
    @Autowired
    private ContratRepository ContratRepo;

    @Autowired
    private EtudiantRepository EtudiantRepo;

public String addContrat (Contrat C)
{
    Contrat Contrat = ContratRepo.save(C);
    if (Contrat!=null)
    {
        return "contrat ajouté";
    }
    else
        return "contrat non ajouté ";

}

    @Override
    public List<Contrat> GetAllContrats() {
        return  (List<Contrat>)ContratRepo.findAll();
    }

    @Override
    public Contrat updateContrat(Long Id, Contrat C) {
        if (ContratRepo.existsById(Id)) {
            Contrat contrat = ContratRepo.findById(Id).get();
            contrat.setDateDebutContrat(C.getDateDebutContrat());
            contrat.setDateFinContrat(C.getDateFinContrat());
            contrat.setArchive(C.getArchive());
            contrat.setSpecialite(C.getSpecialite());
            ContratRepo.save(contrat);
            return contrat;
        } else {
            return null;
        }
    }
    @Override
    public Contrat GetContratById(Long Id) {
        return ContratRepo.findById(Id).get();
    }

    @Override
    public void DeleteContrat(Long Id) {
        ContratRepo.deleteById(Id);

    }



    /////Affecter un contrat à un étudiant en vérifiant que l’étudiant n’a pas dépassé la limite autorisée de 5 contrats actifs.
    @Override
    public Contrat affectContratToEtudiant(Contrat C, String nomE, String prenomE) {
        int nb=0;
        Etudiant E=EtudiantRepo.findByNomEAndPrenomE(nomE,prenomE);
        List<Contrat> contrats =E.getContrats();
        for(Contrat Ce:contrats)
        {
            if (Ce.getArchive()==false)
            {
               nb=nb+1;
            }

        }
        if (nb<5)
        {
            C.setEtudiant(E);
            return ContratRepo.save(C);

        }
        else
        {
        return null;
       }


    }




}
