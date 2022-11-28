package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService implements DepartementServiceInterface{

    @Autowired
    private DepartementRepository DepartRep;


    @Override
    public List<Departement> getListeDeparts() {
        return (List<Departement>) DepartRep.findAll();
    }

    @Override
    public Departement getDepartById(Long id) {
        Departement C=DepartRep.findById(id).get();
        return C ;
    }

    @Override
    public String addDepart(Departement D) {
        Departement D1= DepartRep.save(D);
        if (D1!=null)
        {
            return("Departement ajouté ");

        }
        else {
            return ("Departement non ajouté ");
        }


    }


    @Override
    public Departement updateDepart(Long id, Departement D) {
        if(DepartRep.existsById(id))
        {
        Departement D1=DepartRep.findById(id).get();
        D1.setNomDepart(D.getNomDepart());
        D1.setBloc(D.getBloc());
        DepartRep.save(D1);
        return D1;
        }
        else
            return null;

    }

    @Override
    public void deleteDepart(Long id) {

        DepartRep.deleteById(id);

    }

}
