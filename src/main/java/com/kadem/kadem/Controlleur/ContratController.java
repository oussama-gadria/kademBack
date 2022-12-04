package com.kadem.kadem.Controlleur;

import com.kadem.kadem.Entities.Contrat;
import com.kadem.kadem.Entities.Etudiant;
import com.kadem.kadem.ExceptionHandlingEtudiantContrat.InvalidExceptionEtudiantContrat;
import com.kadem.kadem.Services.ContratServiceInterface;
import com.kadem.kadem.Services.EtudiantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Contrat")
public class ContratController {

    @Autowired
    private ContratServiceInterface contratServ;

    @PostMapping("/addContrat")
    public String addContrat(@RequestBody Contrat C) {
        return contratServ.addContrat(C);
    }

    @GetMapping("/getAllContrat")
    public List<Contrat> getAllContrat() {
        return contratServ.GetAllContrats();
    }

    @GetMapping("/getContratbyId/{id}")
    public Contrat getContratById(@PathVariable("id") Long Id) {
        return contratServ.GetContratById(Id);
    }

    @PutMapping("/upadateContrat/{id}")
    public Contrat updateContrat(@PathVariable("id") Long Id, @RequestBody Contrat C) {
        return contratServ.updateContrat(Id, C);
    }

    @DeleteMapping("/deleteContrat/{id}")
    public void DeleteContrat(@PathVariable("id") Long Id) {
        contratServ.DeleteContrat(Id);
    }


    /////Affecter un contrat à un étudiant en vérifiant que l’étudiant n’a pas dépassé la limite autorisée de 5 contrats actifs.
    @PostMapping("/AddEtudiantToContrat/{nom}/{prenom}/{email}")
    public Contrat AddEtudiantToContrat(@RequestBody Contrat contrat, @PathVariable("nom") String nom, @PathVariable("prenom") String prenom, @PathVariable("email") String email) throws InvalidExceptionEtudiantContrat {
        return contratServ.affectContratToEtudiant(contrat, nom, prenom, email);
    }

    ////afficher les contrats d'un etudiant avec filtrage
    @GetMapping("/filterContratByEtudiant/{idEtudiant}/{startDate}/{EndDate}/{archive}")
    public List<Contrat> filterContratByEtudiant(@PathVariable("idEtudiant") Long IdEtudiant, @PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @PathVariable("EndDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date EndDate, @PathVariable("archive") boolean archive) throws InvalidExceptionEtudiantContrat  {

        return contratServ.getALLcontratsByIdEtudiantwithFiltrage(IdEtudiant, startDate, EndDate, archive);
    }

    @GetMapping("/getContratByidEtudiant/{idEtudiant}")
    public List<Contrat> getContratByidEtudiant(@PathVariable("idEtudiant") Long IdEtudiant) {

        return contratServ.getContratByIdEtudiant(IdEtudiant);
    }



}
