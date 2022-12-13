package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService implements DepartementServiceInterface{

    @Autowired
    private DepartementRepository departRep;


    @Override
    public List<Departement> getListeDeparts() {
        return (List<Departement>) departRep.findAll();
    }

    @Override
    public Departement getDepartById(Long id) {
        Departement C=departRep.findById(id).get();
        return C ;
    }



    @Override
    public String addDepart(Departement D) {
        Departement D1= departRep.save(D);
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
        if(departRep.existsById(id))
        {
        Departement D1=departRep.findById(id).get();
        D1.setNomDepart(D.getNomDepart());
        D1.setBloc(D.getBloc());
            departRep.save(D1);
        return D1;
        }
        else
            return null;

    }

    @Override
    public void deleteDepart(Long id) {

        departRep.deleteById(id);

    }

    @Override
    public Departement getDepartByname(String nomDepart) {
        return departRep.findByNomDepart(nomDepart);
    }


}
