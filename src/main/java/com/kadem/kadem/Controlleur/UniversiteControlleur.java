package com.kadem.kadem.Controlleur;
import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Entities.Universite;
import com.kadem.kadem.Services.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Universite")
public class UniversiteControlleur {
    @Autowired
    private UniversiteService universiteService;



    @PostMapping("/addUniversite")
    public Universite addUniversite (@RequestBody() Universite u)
    {
        return universiteService.addUnversite(u);
    }

    @GetMapping("/getAllUniversite")
    public List<Universite> getListeUniversite()
    {
        return universiteService.retrieveAllUniversite();
    }


    @GetMapping("/getUniversiteById/{id}")
    public Universite getUniversiteById(@PathVariable("id") Long id)
    {
        return universiteService.retrieveUniversite(id);
    }

    @PutMapping("/updateUniversite/{id}")
    public Universite updateContrat(@PathVariable("id")Long id,@RequestBody() Universite u )
    {
        return universiteService.updateUniversite(u,id);
    }

    @DeleteMapping("/deleteUniversite/{id}")
    public Long deleteContrat (@PathVariable("id") Long id)
    {
      return universiteService.deleteUniversite(id);
    }
    @PostMapping("/addDepartementToUniversite/{nomUniversite}/{nomDepartement}")
    public String addDepartementToUniversite(@PathVariable("nomDepartement") String nomDepartement,@PathVariable("nomUniversite") String nomUniversite)
    {
        return universiteService.addDepartementToUniversite(nomDepartement,nomUniversite);
    }
    @GetMapping("/getDepartmentByUniversite/{idUniversite}")
    public List<Departement> getDepartmentByUniversite(@PathVariable("idUniversite") Long idUniversite)
    {

        return universiteService.getDepartmentsByUniversite(idUniversite);
    }
    @GetMapping("/getChiffreAffaireEntreDeuxDate/{startDate}/{endDate}")
        public String getChiffreAffaireEntreDeuxDate(@PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date sDate , @PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date eDate)
        {
         return universiteService.getChiffreAffaireEntreDeuxDate(sDate,eDate);
        }

}

