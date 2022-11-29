package com.kadem.kadem.Controlleur;

import com.kadem.kadem.Entities.Club;
import com.kadem.kadem.Entities.Evenement;
import com.kadem.kadem.Services.ClubServiceInterface;
import com.kadem.kadem.Services.EvenementServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/upadateEvenement/{id}")
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

}
