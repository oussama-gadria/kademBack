package com.kadem.kadem.Controlleur;

import com.kadem.kadem.Entities.Enseignant;
import com.kadem.kadem.Services.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Enseignant")
public class EnseignantControlleur {
    @Autowired
    private EnseignantService enseignantService;



    @PostMapping("/addEnseignant")
    public Enseignant addEnseignant (@RequestBody() Enseignant e)
    {
        return enseignantService.addEnseignant(e);
    }

    @GetMapping("/getAllEnseignant")
    public List<Enseignant> getListeEnseignant()
    {
        return enseignantService.retrieveAllEnseignant();
    }


    @GetMapping("/getEnseignantById/{id}")
    public Enseignant getUniversiteById(@PathVariable("id") Long id)
    {
        return enseignantService.retrieveEnseignant(id);
    }

    @PutMapping("/updateEnseignant/{id}")
    public Enseignant updateContrat(@PathVariable("id")Long id,  @RequestBody() Enseignant e )
    {
        return enseignantService.updateEnseignant(e,id);
    }

    @DeleteMapping("/deleteEnseignant/{id}")
    public Long deleteContrat(@PathVariable("id") Long id)
    {
        return enseignantService.deleteEnseignant(id);
    }

   @PostMapping("/addEnseignantWithUniversite/{nom}")
    public Enseignant addEnseignantWithUniversite(@RequestBody() Enseignant e,@PathVariable("nom")String nom)
    {
        return enseignantService.addEnseignantWithUniversite(nom,e);

    }
    @GetMapping("/getEnseignantByNomUniversite/{nomUniversite}")
    public List<Enseignant> getEnseignantByNomUniversite(@PathVariable("nomUniversite") String nomUniversite)
    {
        return enseignantService.getEnseignantByNomUniversite(nomUniversite);
    }

}
