package com.kadem.kadem.Controlleur;

import com.kadem.kadem.Entities.Administrateur;
import com.kadem.kadem.Entities.Etudiant;
import com.kadem.kadem.Services.AdministrateurServiceInterface;
import com.kadem.kadem.Services.EtudiantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Administrateur")

public class AdministrateurController {

    @Autowired
    private AdministrateurServiceInterface administrateurServ;

    @PostMapping("/addAdmin")
    public Administrateur addAdmin (@RequestBody Administrateur A )
    {
        return administrateurServ.addAdmin(A);
    }



    @GetMapping("/getAdminById/{id}")
    public Administrateur getAdminById(@PathVariable("id") Long Id )
    {
        return administrateurServ.GetAdminById(Id);
    }

    @PutMapping("/upadateAdmin/{id}")
    public Administrateur updateAdmin(@PathVariable("id") Long Id,@RequestBody Administrateur A)
    {
        return administrateurServ.updateAdmin(Id,A);
    }
}
