package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Entities.Universite;

import java.util.Date;
import java.util.List;

public interface UniversiteServiceInterface {
    List<Universite> retrieveAllUniversite();
    Universite addUnversite(Universite u);
    Universite updateUniversite(Universite u ,Long idUniversite);
    Universite retrieveUniversite(Long idUniversite);
    Long deleteUniversite(Long idUniversite);
    String addDepartementToUniversite(String nomDepartement,String nomUniversite);
    List<Departement> getDepartmentsByUniversite(Long idUniv);
    String getChiffreAffaireEntreDeuxDate(Date startDate,Date endDate);
}
