package com.kadem.kadem.Controlleur;
import com.kadem.kadem.Entities.Universite;
import com.kadem.kadem.Services.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}

