package com.kadem.kadem.Controlleur;


import com.kadem.kadem.Entities.Club;
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





}
