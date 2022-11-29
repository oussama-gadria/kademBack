package com.kadem.kadem.Controlleur;

import com.kadem.kadem.Entities.Etudiant;
import com.kadem.kadem.Services.EtudiantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Etudiant")

public class EtudiantController {
    @Autowired
    private EtudiantServiceInterface EtudiantServ;

    @PostMapping("/addEtudiant")
    public String addEtudiant (@RequestBody Etudiant E )
    {
        return EtudiantServ.addEtudiant(E);
    }

    @GetMapping("/getAllEtudiant")
    public List<Etudiant> getAllEtudiant ()
    {
        return EtudiantServ.GetAllEtudiants();
    }

    @GetMapping("/getEtudiantbyId/{id}")
    public Etudiant getEtudiantById(@PathVariable("id") Long Id )
    {
        return EtudiantServ.GetEtudiantById(Id);
    }

    @PutMapping("/updateEtudiant/{id}")
    public Etudiant updateEtudiant(@PathVariable("id") Long Id,@RequestBody Etudiant E)
    {
        return EtudiantServ.updateEtudiant(Id,E);
    }

    @DeleteMapping("/deleteEtudiant/{id}")
    public void DeleteEtudiant(@PathVariable("id") Long Id)
    {
        EtudiantServ.DeleteEtudiant(Id);
    }


    /////affecter un étudiant à un département(id Depart)
    @PostMapping("/addDepartToEtudiantwithID/{idE}/{idD}")
    public void assignEtudiantToDepartement(@PathVariable("idE") Long idE,@PathVariable("idD") Long idD)
    {
        EtudiantServ.assignEtudiantToDepartement(idE,idD);
    }

    //ajouter et affecter un étudiant à une équipe et un contrat en utilisant une seule méthode
    @PostMapping("/addEtudiantWithContratAndEquipe/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract (@RequestBody Etudiant E,@PathVariable("idContrat") Long idContrat, @PathVariable("idEquipe") Long idEquipe )
    {
        return EtudiantServ.addAndAssignEtudiantToEquipeAndContract(E,idContrat,idEquipe);
    }



}
