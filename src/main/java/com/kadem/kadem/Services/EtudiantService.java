package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Contrat;
import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Entities.Equipe;
import com.kadem.kadem.Entities.Etudiant;
import com.kadem.kadem.Repository.ContratRepository;
import com.kadem.kadem.Repository.DepartementRepository;
import com.kadem.kadem.Repository.EquipeRepository;
import com.kadem.kadem.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EtudiantService  implements EtudiantServiceInterface{
    @Autowired
    private EtudiantRepository etudiantRepo;

    @Autowired
    private DepartementRepository departementRepo;

    @Autowired
    private ContratRepository contratRepo;
    @Autowired
    private EquipeRepository equipeRepo;
    @Override
    public String addEtudiant(Etudiant E) {
        Etudiant etudiant=etudiantRepo.save(E);
        if(etudiant!=null)
            return "Etudiant Ajouté";
        else
            return "Etudiant non Ajouté";
    }

    @Override
    public List<Etudiant> GetAllEtudiants() {

        return (List<Etudiant>)etudiantRepo.findAll();
    }

    @Override
    public Etudiant updateEtudiant(Long Id, Etudiant E) {
        if (etudiantRepo.existsById(Id)) {
            Etudiant etudiant = etudiantRepo.findById(Id).get();
            etudiant.setNomE(E.getNomE());
            etudiant.setPrenomE(E.getPrenomE());
            etudiant.setOption(E.getOption());
            etudiantRepo.save(etudiant);
            return etudiant;
        }
        else
        {
            return null;
        }
    }

    @Override
    public Etudiant GetEtudiantById(Long Id) {

        return etudiantRepo.findById(Id).get();
    }

    @Override
    public void DeleteEtudiant(Long Id) {
        etudiantRepo.deleteById(Id);

    }


    ////affecter un étudiant à un département(id Depart)
    @Override
    public void assignEtudiantToDepartement(Long etudiantId, Long departementId) {
        Etudiant E=etudiantRepo.findById(etudiantId).get();
        Departement D= departementRepo.findById(departementId).get();
        E.setDepartement(D);
        etudiantRepo.save(E);

    }

    //ajouter et affecter un étudiant à une équipe et un contrat en utilisant une seule méthode
    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe) {
        Contrat contrat=contratRepo.findById(idContrat).get();
        Equipe equipe=equipeRepo.findById(idEquipe).get();
        Etudiant etudiant = etudiantRepo.save(e);
        contrat.setEtudiant(etudiant);
        if (equipe.getEtudiants() != null){
            equipe.getEtudiants().add(etudiant);
        }
        else{
            List<Etudiant> lE = new ArrayList<Etudiant>();
            lE.add(etudiant);
            equipe.setEtudiants(lE);

        }
contratRepo.save(contrat);
        equipeRepo.save(equipe);

        return etudiant;
    }







}
