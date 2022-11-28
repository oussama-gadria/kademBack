package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Entities.Module;
import com.kadem.kadem.Repository.DepartementRepository;
import com.kadem.kadem.Repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService implements ModuleServiceInterface{
    @Autowired
    private ModuleRepository ModuleRep;


    @Override
    public List<Module> getListeModules() {
        return (List<Module>) ModuleRep.findAll();
    }

    @Override
    public Module getModuleById(Long id) {
        Module C=ModuleRep.findById(id).get();
        return C ;
    }

    @Override
    public String addModule(Module M) {
        Module M1= ModuleRep.save(M);
        if (M1!=null)
        {
            return("Module ajouté ");

        }
        else {
            return ("Module non ajouté ");
        }


    }


    @Override
    public Module updateModule(Long id, Module M) {
        if(ModuleRep.existsById(id))
        {
            Module M1=ModuleRep.findById(id).get();
            M1.setNomModule(M.getNomModule());
            M1.setNbrMatieres((M.getNbrMatieres()));
            ModuleRep.save(M1);
            return M1;
        }
        else
            return null;

    }

    @Override
    public void deleteModule(Long id) {

        ModuleRep.deleteById(id);

    }

}
