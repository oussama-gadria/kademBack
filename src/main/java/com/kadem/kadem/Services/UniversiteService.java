package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Contrat;
import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Entities.Specialite;
import com.kadem.kadem.Entities.Universite;
import com.kadem.kadem.Repository.ContratRepository;
import com.kadem.kadem.Repository.DepartementRepository;
import com.kadem.kadem.Repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UniversiteService implements UniversiteServiceInterface{
    @Autowired
    private UniversiteRepository universiteRepository;
    @Autowired
    private DepartementRepository departementRepository;
    @Autowired
    private ContratRepository contratRepository;
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
        upUniversite.setNomUniversite(u.getNomUniversite());
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

    @Override
    public String addDepartementToUniversite(String nomDepartement, String nomUniversite) {
        Universite univ=universiteRepository.findByNomUniversite(nomUniversite);
        Departement dept=departementRepository.findByNomDepart(nomDepartement);
        List<Departement> ListDepartement=univ.getDepartements();
        ListDepartement.add(dept);
        universiteRepository.save(univ);
        return "Add " +dept.getNomDepart()+ "departement to "+univ.getNomUniversite()+" universite";
    }
    @Override
    public List<Departement> getDepartmentsByUniversite(Long idUniversite)
    {
        Universite univ=universiteRepository.findById(idUniversite).get();
        return univ.getDepartements();

    }

    @Override
    public String getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        float montantCLOUD=0;
        float montantIA=0;
        float montantSECURITE=0;
        float montantRESEAUX=0;
       List<Contrat> listContrat= (List<Contrat>) contratRepository.findAll();
       for (Contrat contrat:listContrat)
       {
           //////////////////////////spaecialite IA///////////////////////////////////////////////////////////////
       if (contrat.getSpecialite().equals(Specialite.IA))
        {
          if (startDate.before(contrat.getDateDebutContrat()) && endDate.after(contrat.getDateFinContrat()))
          {
             montantIA=montantIA+contrat.getMontantC();
          }
        }
       ////////////////////////spaecialite RESEAUX//////////////////////////////////////////////////////////
       else if (contrat.getSpecialite().equals(Specialite.RESEAUX))
           {
               if (startDate.before(contrat.getDateDebutContrat()) && endDate.after(contrat.getDateFinContrat()))
               {
                   montantRESEAUX=montantRESEAUX+contrat.getMontantC();
               }
           }
       ////////////////////////spaecialite CLOUD//////////////////////////////////////////////////////////
       else if (contrat.getSpecialite().equals(Specialite.CLOUD))
       {
           if (startDate.before(contrat.getDateDebutContrat()) && endDate.after(contrat.getDateFinContrat()))
           {
               montantCLOUD=montantCLOUD+contrat.getMontantC();
           }
       }
       ////////////////////////spaecialite SECURITE//////////////////////////////////////////////////////////
       else if (contrat.getSpecialite().equals(Specialite.SECURITE))
       {
           if (startDate.before(contrat.getDateDebutContrat()) && endDate.after(contrat.getDateFinContrat()))
           {
               montantSECURITE=montantSECURITE+contrat.getMontantC();
           }
       }
       ////////////////////////////////////////////////////////////////////////////////////////////////////////
       }
        return "Pour un contrat dont la specialite est IA: "+montantIA+"Dt/mois" +"\n"+
                "Pour un contrat dont la specialite est Reseaux: "+montantRESEAUX+"Dt/mois"+"\n"+
                "Pour un contrat dont la specialite est securite: "+montantSECURITE+"Dt/mois"+"\n"+
                "Pour un contrat dont la specialite est cloud: "+montantCLOUD+"Dt/mois" ;
    }


}
