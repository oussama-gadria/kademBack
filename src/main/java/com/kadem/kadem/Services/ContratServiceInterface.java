package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Contrat;

import java.util.List;

public interface ContratServiceInterface {
    String addContrat (Contrat C);
    List<Contrat> GetAllContrats();
    Contrat updateContrat (Long Id,Contrat C );
    Contrat GetContratById (Long Id);
    void DeleteContrat(Long Id);



}
