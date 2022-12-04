package com.kadem.kadem.Controlleur;


import com.kadem.kadem.Entities.Club;
import com.kadem.kadem.ExceptionHandlingClubEvent.InvalidExceptionClubEvent;
import com.kadem.kadem.Services.ClubServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Club")
public class ClubController {

     @Autowired
     private ClubServiceInterface ClubServ;

    @PostMapping("/addClub")
    public Club addClub (@RequestBody Club club )
    {
        return ClubServ.addClub(club);
    }

    @GetMapping("/getAllClubs")
    public List<Club> getAllClubs ()
    {
        return ClubServ.GetAllClubs();
    }

    @GetMapping("/getClubById/{id}")
    public Club getClubById (@PathVariable("id") Long Id )
    {
        return ClubServ.GetClubById(Id);
    }

    @PutMapping("/upadateClub/{id}")
    public Club updateClub(@PathVariable("id") Long Id,@RequestBody Club cl)
    {
        return ClubServ.updateClub(Id,cl);
    }
    @DeleteMapping("/deleteClub/{id}")
    public void DeleteClub(@PathVariable("id") Long Id)
    {
        ClubServ.DeleteClub(Id);
    }


    @PostMapping("/addClubwithResponsable/{prenom}/{nom}/{email}")
    public Club addClubWithResponsable (@RequestBody Club club,@PathVariable("prenom") String prenom,@PathVariable("nom") String nom,@PathVariable("email") String email) throws InvalidExceptionClubEvent
    {
        return ClubServ.addClubWithResponsable(club,prenom,nom,email);
    }


    @PostMapping("/assignEtudiantToClub/{prenom}/{nom}/{email}/{idClub}")
    public Club assignEtudiantToClub(@PathVariable("prenom") String prenom,@PathVariable("nom") String nom,@PathVariable("email") String email,@PathVariable("idClub") Long idClub){
        return ClubServ.assignEtudiantToClub(prenom, nom, email , idClub);
    }

    @GetMapping("/GetClubsByIdEtudiant/{idEtudiant}")
    public List<Club> GetClubsByIdEtudiant (@PathVariable("idEtudiant") Long idEtudiant )
    {
        return ClubServ.GetClubsByIdEtudiant(idEtudiant);
    }


}
