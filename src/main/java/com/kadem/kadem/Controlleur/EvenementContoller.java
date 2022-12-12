package com.kadem.kadem.Controlleur;


import com.kadem.kadem.Entities.Evenement;

import com.kadem.kadem.Services.EvenementServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Evenement")
public class EvenementContoller {

    @Autowired
    private EvenementServiceInterface EvenementServ;

    @PostMapping("/addEvenement")
    public Evenement addEvenement (@RequestBody Evenement evenement )
    {
        return EvenementServ.addEvenement(evenement);
    }

    @GetMapping("/getAllEvenements")
    public List<Evenement> getAllEvenements ()
    {
        return EvenementServ.GetAllEvenements();
    }

    @GetMapping("/getEvenementById/{id}")
    public Evenement getEvenementById (@PathVariable("id") Long Id )
    {
        return EvenementServ.GetEvenementById(Id);
    }

    @PutMapping("/updateEvenement/{id}")
    public Evenement updateEvenement(@PathVariable("id") Long Id,@RequestBody Evenement event)
    {
        return EvenementServ.updateEvenement(Id,event);
    }
    @DeleteMapping("/deleteEvenement/{id}")
    public void DeleteEvenement(@PathVariable("id") Long Id)
    {
        EvenementServ.DeleteEvenement(Id);
    }


     @PostMapping("/addEvenementWithClubId/{id}")
    public Evenement addEvenementWithClubId(@PathVariable("id") Long IdC, @RequestBody Evenement E){
        return EvenementServ.addEvenementWithClubId(IdC,E);
    }


    @PostMapping("/AddAndAssignEquipeToEvenement/{idEquipe}")
    public Evenement AddAndAssignEquipeToEvenement(@PathVariable("idEquipe") Long idEquipe,@RequestBody Evenement evenement){
        return EvenementServ.AddAndAssignEquipeToEvenement(idEquipe , evenement);
    }

    @GetMapping("/evenementBetween2dates/{datedebut}/{datefin}")
    public List<Evenement> getEvenementById (@PathVariable("datedebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datedebut , @PathVariable("datefin")  @DateTimeFormat(pattern = "yyyy-MM-dd")Date datefin )
    {
        return EvenementServ.evenementBetween2dates( datedebut ,  datefin);
    }

}
