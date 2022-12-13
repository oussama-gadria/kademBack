package com.kadem.kadem.Controlleur;

import com.kadem.kadem.Entities.Enseignant;
import com.kadem.kadem.Entities.Etudiant;
import com.kadem.kadem.Entities.Option;
import com.kadem.kadem.ExceptionHandlingEtudiantContrat.InvalidExceptionEtudiantContrat;
import com.kadem.kadem.Services.EtudiantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/Etudiant")

public class EtudiantController {
    @Autowired
    private EtudiantServiceInterface etudiantServ;

    @PostMapping("/addEtudiant")
    public String addEtudiant (@RequestBody Etudiant E )
    {
        return etudiantServ.addEtudiant(E);
    }

    @GetMapping("/getAllEtudiant")
    public List<Etudiant> getAllEtudiant ()
    {
        return etudiantServ.GetAllEtudiants();
    }

    @GetMapping("/getEtudiantbyId/{id}")
    public Etudiant getEtudiantById(@PathVariable("id") Long Id )
    {
        return etudiantServ.GetEtudiantById(Id);
    }

    @PutMapping("/updateEtudiant/{id}")
    public Etudiant updateEtudiant(@PathVariable("id") Long Id,@RequestBody Etudiant E)
    {
        return etudiantServ.updateEtudiant(Id,E);
    }

    @DeleteMapping("/deleteEtudiant/{id}")
    public void DeleteEtudiant(@PathVariable("id") Long Id)
    {
        etudiantServ.DeleteEtudiant(Id);
    }


    /////affecter un étudiant à un département(nom depart)
    @PostMapping("/AddEtudiantWithDepart/{nomDepartement}")
    public Etudiant assignEtudiantToDepartement(@PathVariable("nomDepartement") String nomDepartement, @RequestBody Etudiant etudiant) throws InvalidExceptionEtudiantContrat
    {
       return  etudiantServ.assignEtudiantToDepartementWithNomD(etudiant,nomDepartement);
    }

    //ajouter et affecter un étudiant à une équipe et un contrat en utilisant une seule méthode
    @PostMapping("/addEtudiantWithContratAndEquipe/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract (@RequestBody Etudiant E,@PathVariable("idContrat") Long idContrat, @PathVariable("idEquipe") Long idEquipe )
    {
        return etudiantServ.addAndAssignEtudiantToEquipeAndContract(E,idContrat,idEquipe);
    }

    ////////trier les étudiants selon leur moyennes par classe/niveau et option
    @GetMapping("/getEtudiantOrderByMoyenne/{nomDepartement}/{niveau}/{option}/{classe}")
    public List<Etudiant> getEtudiantOrderByMoyenne(@PathVariable("nomDepartement") String  nomDepartement,@PathVariable("niveau") Integer  niveau, @PathVariable("option") Option option,@PathVariable("classe") Integer  classe )
    {
        return etudiantServ.getEtudiantOrderByMoyenne(nomDepartement,option,niveau,classe);
    }

    /////afficher la liste des enseignants de chaque etudiants groupés par le nom du module(à tester)
    @GetMapping("/getEnseignantsByIdEtudiantGroupByModule/{idEtudiant}")
    public List<Enseignant> getEnseignantsByIdEtudiantGroupByModule(@PathVariable("idEtudiant") Long idEtudiant )
    {
        return etudiantServ.getEnseignantsByIdEtudiantGroupByModule(idEtudiant);
    }


}
