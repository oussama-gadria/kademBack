package com.kadem.kadem.Controlleur;

import com.kadem.kadem.Entities.BLOC;
import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Services.DepartementService;
import com.kadem.kadem.Services.DepartementServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Departement")
public class DepartementControlleur {

    @Autowired
    private DepartementServiceInterface DepartementService;


    @PostMapping("/addDepart")
    public String addDepart (@RequestBody()Departement D)
    {
        return DepartementService.addDepart(D);
    }

    @GetMapping("/getAllDeparts")
    public List<Departement> getListeDeparts()
    {
        return DepartementService.getListeDeparts();
    }


    @GetMapping("/getDepartById/{id}")
    public Departement getDepartById(@PathVariable("id") Long id)
    {
        return DepartementService.getDepartById(id);
    }



    @GetMapping("/getDepartBynom/{nomDepart}")
    public Departement getDepartByNom(@PathVariable("nomDepart") String nomDepart)
    {
        return DepartementService.getDepartByname(nomDepart);
    }

    @PutMapping("/updateDepart/{id}")
    public Departement updateDepart(@PathVariable("id")Long id,  @RequestBody() Departement D )
    {
        return DepartementService.updateDepart(id,D);
    }

    @DeleteMapping("/deleteDepart/{id}")
    public void deleteDepart (@PathVariable("id") Long id)
    {
         DepartementService.deleteDepart(id);
    }





}
