package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Club;
import com.kadem.kadem.Repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService implements ClubServiceInterface {

    @Autowired
    private ClubRepository ClubRepo ;

    @Override
    public List<Club> GetAllClubs() {
        return  (List<Club>)ClubRepo.findAll();
    }


    @Override
    public Club addClub(Club club) {
        return ClubRepo.save(club);
    }


    @Override
    public Club GetClubById(Long Id) {
        return ClubRepo.findById(Id).get();
    }


    @Override
    public Club updateClub(Long Id, Club cl) {
        if (ClubRepo.existsById(Id)) {
            Club club = ClubRepo.findById(Id).get();
            club.setNomClub(cl.getNomClub());
            ClubRepo.save(club);
            return club;
        } else {
            return null;
        }
    }

     @Override
    public void DeleteClub(Long Id) {
        ClubRepo.deleteById(Id);

    }





}
