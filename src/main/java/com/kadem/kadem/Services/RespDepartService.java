package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.RespDepart;
import com.kadem.kadem.Repository.RespDepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespDepartService implements  RespDepartServiceInterface{

    @Autowired
    private RespDepartRepository RespDepart;


    @Override
    public List<RespDepart> getListeRespDeparts() {
        return (List<RespDepart>) RespDepart.findAll();
    }

    @Override
    public RespDepart getRespDepartById(Long id) {
        RespDepart R=RespDepart.findById(id).get();
        return R ;
    }

    @Override
        public String addRespDepart(RespDepart R) {
        RespDepart R1= RespDepart.save(R);
        if (R1!=null)
        {
            return("Responsable Departement ajouté ");

        }
        else {
            return ("Responsable Departement non ajouté ");
        }


    }


    @Override
    public RespDepart updateRespDepart(Long id, RespDepart R) {
        if(RespDepart.existsById(id))
        {
        RespDepart R1=RespDepart.findById(id).get();
        R1.setNomRespDepart(R.getNomRespDepart());
        R1.setPrenomRespDepart(R.getPrenomRespDepart());
        RespDepart.save(R1);
        return R1;
        }
        else return null;

    }



    @Override
    public void deleteRespDepart(Long id) {
        RespDepart.deleteById(id);


    }


}
