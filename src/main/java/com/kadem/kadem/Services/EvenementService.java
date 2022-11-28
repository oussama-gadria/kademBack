package com.kadem.kadem.Services;


import com.kadem.kadem.Entities.Club;
import com.kadem.kadem.Entities.Evenement;
import com.kadem.kadem.Repository.ClubRepository;
import com.kadem.kadem.Repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementService implements EvenementServiceInterface {


    @Autowired
    private EvenementRepository EvenementRepo ;

    @Autowired
    private ClubRepository ClubRepo ;


    @Override
    public List<Evenement> GetAllEvenements() {
        return  (List<Evenement>)EvenementRepo.findAll();
    }


    @Override
    public Evenement addEvenement(Evenement evenement) {
        return EvenementRepo.save(evenement);
    }


    @Override
    public Evenement GetEvenementById(Long Id) {
        return EvenementRepo.findById(Id).get();
    }



    @Override
    public Evenement updateEvenement(Long Id, Evenement event) {
        if (EvenementRepo.existsById(Id)) {
            Evenement evenement = EvenementRepo.findById(Id).get();
            evenement.setNomEvenement(event.getNomEvenement());
            evenement.setDateEvenement(event.getDateEvenement());
            evenement.setEmplacementEvenement(event.getEmplacementEvenement());
            EvenementRepo.save(evenement);
            return evenement;
        } else {
            return null;
        }
    }

     @Override
    public void DeleteEvenement(Long Id) {
        EvenementRepo.deleteById(Id);

    }


      @Override
    public Evenement addEvenementWithClubId(long IdC, Evenement E){
        Club c = ClubRepo.findById(IdC).get();
        E.setClub(c);
        EvenementRepo.save(E);
        return E;
    }


}
