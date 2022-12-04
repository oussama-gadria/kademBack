package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Contrat;
import com.kadem.kadem.Entities.Etudiant;
import com.kadem.kadem.ExceptionHandlingEtudiantContrat.InvalidExceptionEtudiantContrat;
import com.kadem.kadem.Repository.ContratRepository;
import com.kadem.kadem.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContratService implements ContratServiceInterface{
    @Autowired
    private ContratRepository contratRepo;

    @Autowired
    private EtudiantRepository EtudiantRepo;

public String addContrat (Contrat C)
{
    Contrat Contrat = contratRepo.save(C);
    if (Contrat!=null)
    {
        return "contrat ajouté";
    }
    else
        return "contrat non ajouté ";

}

    @Override
    public List<Contrat> GetAllContrats() {
        return  (List<Contrat>)contratRepo.findAll();
    }

    @Override
    public Contrat updateContrat(Long Id, Contrat C) {
        if (contratRepo.existsById(Id)) {
            Contrat contrat = contratRepo.findById(Id).get();
            contrat.setDateDebutContrat(C.getDateDebutContrat());
            contrat.setDateFinContrat(C.getDateFinContrat());
            contrat.setArchive(C.getArchive());
            contrat.setSpecialite(C.getSpecialite());
            contratRepo.save(contrat);
            return contrat;
        } else {
            return null;
        }
    }
    @Override
    public Contrat GetContratById(Long Id) {
        return contratRepo.findById(Id).get();
    }

    @Override
    public void DeleteContrat(Long Id) {
        contratRepo.deleteById(Id);

    }





    /////Affecter un contrat à un étudiant en vérifiant que l’étudiant n’a pas dépassé la limite autorisée de 5 contrats actifs.
    @Override
    public Contrat affectContratToEtudiant(Contrat contrat, String nomE, String prenomE, String emailEtudiant) throws InvalidExceptionEtudiantContrat {

        Etudiant etudiant=EtudiantRepo.findByNomEAndPrenomEAndEmail(nomE,prenomE,emailEtudiant);

        if(contratRepo.countByArchiveAndEtudiantIdEtudiant(false,etudiant.getIdEtudiant()) < 5)
        {
            contrat.setEtudiant(etudiant);
            return contratRepo.save(contrat);
        }
        else
        {
            throw new InvalidExceptionEtudiantContrat("vous avez déja 5 contrat actifs! Vous ne pouvez plus ajouter un autre contrat.");
       }


    }
    ////afficher les contrats d'un etudiant avec filtrage
    @Override
    public List<Contrat> getALLcontratsByIdEtudiantwithFiltrage(Long idEtudiant, Date dateDebut, Date dateFin, boolean x) throws InvalidExceptionEtudiantContrat {
        if (contratRepo.filterContratByEtudiant(idEtudiant, dateDebut, dateFin, x).isEmpty()) {
            throw new InvalidExceptionEtudiantContrat("Aucune resultat trouvées ");
        }
        else
        {
            return contratRepo.filterContratByEtudiant(idEtudiant, dateDebut, dateFin, x);
        }
    }

    @Override
    public List<Contrat> getContratByIdEtudiant(Long idEtudiant) {

        return contratRepo.findByEtudiantIdEtudiant(idEtudiant);
    }


}
