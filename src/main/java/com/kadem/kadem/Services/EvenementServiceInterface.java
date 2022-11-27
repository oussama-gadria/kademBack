package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Evenement;

import java.util.List;

public interface EvenementServiceInterface {



    List<Evenement > GetAllEvenements();

    Evenement addEvenement(Evenement evenement);

    Evenement updateEvenement (Long Id,Evenement event );

    Evenement GetEvenementById (Long Id);

    void DeleteEvenement (Long Id);


}
