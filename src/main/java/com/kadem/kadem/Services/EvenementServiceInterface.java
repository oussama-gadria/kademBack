package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Etudiant;
import com.kadem.kadem.Entities.Evenement;

import java.util.Date;
import java.util.List;

public interface EvenementServiceInterface {



    List<Evenement > GetAllEvenements();

    Evenement addEvenement(Evenement evenement);

    Evenement updateEvenement (Long Id,Evenement event );

    Evenement GetEvenementById (Long Id);

    void DeleteEvenement (Long Id);



    Evenement addEvenementWithClubId (long IdC, Evenement E);


    public Evenement AddAndAssignEquipeToEvenement(Long idEquipe , Evenement E);

    public  List<Evenement> evenementBetween2dates(Date datedebut , Date datefin);
}
