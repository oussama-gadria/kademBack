package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.*;
import com.kadem.kadem.Entities.Module;
import com.kadem.kadem.Repository.ContratRepository;
import com.kadem.kadem.Repository.DepartementRepository;
import com.kadem.kadem.Repository.EvenementRepository;
import com.kadem.kadem.Repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private EvenementRepository evenementRepository;
    //////////////////////////////////////////////CRUD////////////////////////////////////////////////////////////
    @Override
    public List<Universite> retrieveAllUniversite() {
        return  (List<Universite>) universiteRepository.findAll() ;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Universite addUnversite(Universite u) {
        Universite u1=universiteRepository.save(u);
        return u1;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public Universite updateUniversite(Universite u,Long idUniversite) {
        Universite upUniversite=universiteRepository.findById(idUniversite).get();
        upUniversite.setNomUniversite(u.getNomUniversite());
        universiteRepository.save(upUniversite);
        return upUniversite;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Long deleteUniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);
        return idUniversite;
    }
    ///////////////////////////////////////////FONCTION AVANCEE///////////////////////////////////////////////////////
    @Override
    public String addDepartementToUniversite(Long idDepartement, Long idUniversite) {
        Universite univ=universiteRepository.findById(idDepartement).get();
        Departement dept=departementRepository.findById(idUniversite).get();
        if ((univ!=null)&&(dept!=null)) {
            List<Departement> ListDepartement = univ.getDepartements();
            if (ListDepartement!=null) {
                ListDepartement.add(dept);
                universiteRepository.save(univ);
            }
            else {
                List<Departement> listdept=new ArrayList<Departement>();
                listdept.add(dept);
                univ.setDepartements(listdept);
                universiteRepository.save(univ);
            }
            return "Add " + dept.getNomDepart() + "departement to " + univ.getNomUniversite() + " universite";
        }
        else if((univ==null)&&(dept!=null))
            {
                return "l'univeriste avec l'id"+ idUniversite+" "+"nexiste pas";
            }
        else if((dept==null)&&(univ!=null))
        {
            return "le departement avec l'id "+idDepartement+" "+"nexiste pas";
        }
        else {
            return"le departement avec l'id "+ idDepartement+" et l'univeriste "+idUniversite+" ne sont pas encore définie";
        }
        }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<Departement> getDepartmentsByUniversite(Long idUniversite)
    {
        Universite univ=universiteRepository.findById(idUniversite).get();
        if (univ!=null)
        {return univ.getDepartements();}
        else return null;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
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



    @Override
    public String getAllDetailsUniversiteByIdUniversite(Long idUniversite) {
        Universite univ=universiteRepository.findById(idUniversite).get();
        List<Departement> departements=univ.getDepartements();
        Integer numberOfStudent=0;
        String details1="";
        String details2="";
        String details3="";
        for (Departement department:departements){
            numberOfStudent=numberOfStudent+department.getEtudiants().size();
        }
        for (Departement departement:departements) {
            details1=details1+"le departement "+departement.getNomDepart()+" contient "+(departement.getModules().size())+" module qui sont :";
        for (Module module:departement.getModules()) {
            details2 = details2 + "\n" + module.getNomModule() + " qui contient " + (module.getListEnseignant().size()) + " enseignant";
        }
            details3=details3 + "\n"+details1+details2;
            details1="";
            details2="";
        }
        return univ.getNomUniversite()+" contient "+numberOfStudent+" etudiant qui sont répartie sur "+(departements.size())+" department comme suit :"+ details3;
    }

    @Override
    public List<Evenement> getEvenementByNameUniversite(Long idUniversite, Date DateDebutEvenement, Date DateFinEvenement) {
        List<Evenement> evenements=universiteRepository.getlisteEvenementByIdUniversite(idUniversite);
        List<Evenement> evenements1=new ArrayList<Evenement>();
        for(Evenement evenement:evenements){
            if( (evenement.getDateEvenement().before(DateFinEvenement))&&(evenement.getDateEvenement().after(DateDebutEvenement))){
                evenements1.add(evenement);
            }
        }
        return evenements1;
    }


}
