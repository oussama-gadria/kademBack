package com.kadem.kadem.Controlleur;

import com.kadem.kadem.Entities.Contrat;
import com.kadem.kadem.Entities.Etudiant;
import com.kadem.kadem.Services.ContratServiceInterface;
import com.kadem.kadem.Services.EtudiantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Contrat")
public class ContratController {

    @Autowired
    private ContratServiceInterface ContratServ;

    @PostMapping("/addContrat")
    public String addContrat (@RequestBody Contrat C )
    {
        return ContratServ.addContrat(C);
    }

    @GetMapping("/getAllContrat")
    public List<Contrat> getAllContrat ()
    {
        return ContratServ.GetAllContrats();
    }

    @GetMapping("/getContratbyId/{id}")
    public Contrat getContratById (@PathVariable("id") Long Id )
    {
        return ContratServ.GetContratById(Id);
    }

    @PutMapping("/upadateContrat/{id}")
    public Contrat updateContrat(@PathVariable("id") Long Id,@RequestBody Contrat C)
    {
        return ContratServ.updateContrat(Id,C);
    }
    @DeleteMapping("/deleteContrat/{id}")
    public void DeleteContrat(@PathVariable("id") Long Id)
    {
        ContratServ.DeleteContrat(Id);
    }


}
