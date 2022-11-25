package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Universite;

import java.util.List;

public interface UniversiteServiceInterface {
    List<Universite> retrieveAllUniversite();
    Universite addUnversite(Universite u);
    Universite updateUniversite(Universite u ,Long idUniversite);
    Universite retrieveUniversite(Long idUniversite);
    Long deleteUniversite(Long idUniversite);
}
