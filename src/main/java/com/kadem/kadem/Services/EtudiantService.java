package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Contrat;
import com.kadem.kadem.Entities.Etudiant;
import com.kadem.kadem.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EtudiantService  implements EtudiantServiceInterface{
    @Autowired
    private EtudiantRepository EtudiantRepo;

    @Override
    public String addEtudiant(Etudiant E) {
        Etudiant etudiant=EtudiantRepo.save(E);
        if(etudiant!=null)
            return "Etudiant Ajouté";
        else
            return "Etudiant non Ajouté";
    }

    @Override
    public List<Etudiant> GetAllEtudiants() {

        return (List<Etudiant>)EtudiantRepo.findAll();
    }

    @Override
    public Etudiant updateEtudiant(Long Id, Etudiant E) {
        if (EtudiantRepo.existsById(Id)) {
            Etudiant etudiant = EtudiantRepo.findById(Id).get();
            etudiant.setNomE(E.getNomE());
            etudiant.setPrenomE(E.getPrenomE());
            etudiant.setOption(E.getOption());
            EtudiantRepo.save(etudiant);
            return etudiant;
        }
        else
        {
            return null;
        }
    }

    @Override
    public Etudiant GetEtudiantById(Long Id) {

        return EtudiantRepo.findById(Id).get();
    }

    @Override
    public void DeleteEtudiant(Long Id) {
        EtudiantRepo.deleteById(Id);

    }
}
