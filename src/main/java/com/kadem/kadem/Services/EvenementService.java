package com.kadem.kadem.Services;


import com.kadem.kadem.Entities.Club;
import com.kadem.kadem.Entities.Equipe;
import com.kadem.kadem.Entities.Evenement;
import com.kadem.kadem.Repository.ClubRepository;
import com.kadem.kadem.Repository.EquipeRepository;
import com.kadem.kadem.Repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EvenementService implements EvenementServiceInterface {


    @Autowired
    private EvenementRepository evenementRepo;

    @Autowired
    private ClubRepository clubRepo;

    @Autowired
    private EquipeRepository equipeRepo;


    @Override
    public List<Evenement> GetAllEvenements() {
        return (List<Evenement>) evenementRepo.findAll();
    }


    @Override
    public Evenement addEvenement(Evenement evenement) {
        return evenementRepo.save(evenement);
    }


    @Override
    public Evenement GetEvenementById(Long Id) {
        return evenementRepo.findById(Id).get();
    }


    @Override
    public Evenement updateEvenement(Long Id, Evenement event) {
        if (evenementRepo.existsById(Id)) {
            Evenement evenement = evenementRepo.findById(Id).get();
            evenement.setNomEvenement(event.getNomEvenement());
            evenement.setDateEvenement(event.getDateEvenement());
            evenement.setEmplacementEvenement(event.getEmplacementEvenement());
            evenementRepo.save(evenement);
            return evenement;
        } else {
            return null;
        }
    }

    @Override
    public void DeleteEvenement(Long Id) {
        evenementRepo.deleteById(Id);

    }


    @Override
    public Evenement addEvenementWithClubId(long IdC, Evenement E) {
        Club club = clubRepo.findById(IdC).get();
        E.setClub(club);
        evenementRepo.save(E);
        return E;
    }


    @Override
    public Evenement AddAndAssignEquipeToEvenement(Long idEquipe , Evenement E) {
        Equipe equipe = equipeRepo.findById(idEquipe).get();
        evenementRepo.save(E);
        List<Equipe> equipes = E.getEquipes();
        if (equipes!=null)
        {
            equipes.add(equipe);

        }
     else {
         List<Equipe> equipes1=new ArrayList<Equipe>();
         equipes1.add(equipe);
         E.setEquipes(equipes1);
        }
        evenementRepo.save(E);
        return E;


    }

    @Override

    public  List<Evenement> evenementBetween2dates(Date datedebut , Date datefin) {

        return evenementRepo.evenementBetween2dates(datedebut ,datefin );
    }
}
