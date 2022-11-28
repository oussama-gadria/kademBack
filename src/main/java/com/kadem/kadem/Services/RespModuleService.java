package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.BLOC;
import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Entities.Module;
import com.kadem.kadem.Entities.RespModule;
import com.kadem.kadem.Repository.DepartementRepository;
import com.kadem.kadem.Repository.ModuleRepository;
import com.kadem.kadem.Repository.RespModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespModuleService implements RespModuleServiceInterface {

    @Autowired
    private RespModuleRepository RespDepart;

    @Autowired
    private ModuleRepository ModuleRep;


    @Override
    public List<RespModule> getListeRespModules() {
        return (List<RespModule>) RespDepart.findAll();
    }

    @Override
    public RespModule getRespModuleById(Long id) {
        RespModule R=RespDepart.findById(id).get();
        return R ;
    }

    @Override
        public String addRespModule(RespModule R) {
        RespModule R1= RespDepart.save(R);
        if (R1!=null)
        {
            return("Responsable Departement ajouté ");

        }
        else {
            return ("Responsable Departement non ajouté ");
        }


    }


    @Override
    public RespModule updateRespModule(Long id, RespModule R) {
        if(RespDepart.existsById(id))
        {
        RespModule R1=RespDepart.findById(id).get();
        R1.setNomRespModule(R.getNomRespModule());
        R1.setPrenomRespModule(R.getPrenomRespModule());
        R1.setEmailResp(R.getEmailResp());
        R1.setNomMatiereResp(R.getNomMatiereResp());
        R1.setAgeResp(R.getAgeResp());
        R1.setSalaireResp(R.getSalaireResp());
        R1.setExperienceAnnuelle(R.getExperienceAnnuelle());
        RespDepart.save(R1);
        return R1;
        }
        else return null;

    }



    @Override
    public void deleteRespModule(Long id) {
        RespDepart.deleteById(id);


    }



    @Override
    public RespModule addRespToModule(RespModule R, String nomModule){
        Module Mod= ModuleRep.findByNomModule(nomModule);
        if (Mod!=null) {
            R.setModule(Mod);
            return (RespDepart.save(R));
        }
        else return null;



    }



}
