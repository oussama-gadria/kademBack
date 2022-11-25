package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Contrat;
import com.kadem.kadem.Repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratService implements ContratServiceInterface{
    @Autowired
    private ContratRepository ContratRepo;

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
    Contrat contrat=ContratRepo.findById(Id).get();
    contrat.setDateDebutContrat(C.getDateDebutContrat());
    contrat.setDateFinContrat(C.getDateFinContrat());
    contrat.setArchive(C.getArchive());
    contrat.setSpecialite(C.getSpecialite());
    ContratRepo.save(contrat);
    return contrat;
    }

    @Override
    public Contrat GetContratById(Long Id) {
        return ContratRepo.findById(Id).get();
    }

    @Override
    public void DeleteContrat(Long Id) {
        ContratRepo.deleteById(Id);

    }








}
