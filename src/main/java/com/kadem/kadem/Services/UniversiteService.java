package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Universite;
import com.kadem.kadem.Repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniversiteService implements UniversiteServiceInterface{
    @Autowired
    private UniversiteRepository universiteRepository;
    @Override
    public List<Universite> retrieveAllUniversite() {
        return  (List<Universite>) universiteRepository.findAll() ;
    }

    @Override
    public Universite addUnversite(Universite u) {
        Universite u1=universiteRepository.save(u);
        return u1;
    }

    @Override
    public Universite updateUniversite(Universite u,Long idUniversite) {
        Universite upUniversite=universiteRepository.findById(idUniversite).get();
        upUniversite.setNom_universite(u.getNom_universite());
        universiteRepository.save(upUniversite);
        return upUniversite;
    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    @Override
    public Long deleteUniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);
        return idUniversite;
    }
}
