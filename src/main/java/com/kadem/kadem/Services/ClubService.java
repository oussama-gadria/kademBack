package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Club;
import com.kadem.kadem.Entities.Etudiant;
import com.kadem.kadem.ExceptionHandling.InvalidIdException;
import com.kadem.kadem.ExceptionHandlingClubEvent.InvalidExceptionClubEvent;
import com.kadem.kadem.Repository.ClubRepository;
import com.kadem.kadem.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClubService implements ClubServiceInterface {

    @Autowired
    private ClubRepository clubRepo;

    @Autowired
    private EtudiantRepository etudiantRepo;

    @Override
    public List<Club> GetAllClubs() {
        return (List<Club>) clubRepo.findAll();
    }


    @Override
    public Club addClub(Club club) {
        return clubRepo.save(club);
    }


    @Override
    public Club GetClubById(Long Id) {
        return clubRepo.findById(Id).get();
    }


    @Override
    public Club updateClub(Long Id, Club cl) {
        if (clubRepo.existsById(Id)) {
            Club club = clubRepo.findById(Id).get();
            club.setNomClub(cl.getNomClub());
           // club.setResponsableClub(cl.getResponsableClub());
            clubRepo.save(club);
            return club;
        } else {
            return null;
        }
    }

    @Override
    public void DeleteClub(Long Id) {
        clubRepo.deleteById(Id);

    }

    @Override
    public Club addClubWithResponsable(Club club, String nomEtudiant, String prenomEtudiant, String emailEtudiant) throws InvalidExceptionClubEvent {
        Etudiant etudiant = etudiantRepo.findByNomEAndPrenomEAndEmail(nomEtudiant, prenomEtudiant, emailEtudiant);
        if (etudiant != null) {
            club.setResponsableClub(etudiant);
            clubRepo.save(club);
        } else {
            throw new InvalidExceptionClubEvent("Etudiant n'existe pas");
        }

        return club;
    }


    @Override
    public Club assignEtudiantToClub(String nom, String prenom, String email, Long idClub) {
        Etudiant etudiant = etudiantRepo.findByNomEAndPrenomEAndEmail(nom, prenom, email);
        Club club = clubRepo.findById(idClub).get();
        List<Etudiant> etudiantsclub = club.getEtudiantsclub();
        if (etudiantsclub != null) {
            etudiantsclub.add(etudiant);
        } else {
            List<Etudiant> etudiantsclub1 = new ArrayList<>();
            etudiantsclub1.add(etudiant);
            club.setEtudiantsclub(etudiantsclub1);
        }
        clubRepo.save(club);
        return club;
    }


    public List<Club> GetClubsByIdEtudiant(Long idEtudiant) {

    Etudiant etudiant = etudiantRepo.findById(idEtudiant).get();
        return  etudiant.getClubs();
}
    public Club assignEtudiantToClubbyId(Long id,Long idClub){
        Etudiant etudiant = etudiantRepo.findById(id).orElse(null);
        Club club = clubRepo.findById(idClub).orElse(null);
        club.getEtudiantsclub().add(etudiant);
        clubRepo.save(club);
        return club;
    }

}