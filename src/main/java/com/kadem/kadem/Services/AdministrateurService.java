package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Administrateur;
import com.kadem.kadem.Entities.Etudiant;
import com.kadem.kadem.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministrateurService implements AdministrateurServiceInterface {

   @Autowired
   private AdminRepository adminRepository;


    @Override
    public Administrateur addAdmin(Administrateur A) {
        return adminRepository.save(A);

    }
    

    @Override
    public Administrateur updateAdmin(Long Id, Administrateur A) {
        if (adminRepository.existsById(Id)) {
            Administrateur administrateur = adminRepository.findById(Id).get();
            administrateur.setNomAdmin(A.getNomAdmin());
            administrateur.setPrenomAdmin(A.getPrenomAdmin());
            administrateur.setEmailAdmin(A.getEmailAdmin());
            adminRepository.save(administrateur);
            return administrateur;
        }
        else
        {
            return null;
        }
    }

    @Override
    public Administrateur GetAdminById(Long Id) {

        return adminRepository.findById(Id).get();
    }

}
