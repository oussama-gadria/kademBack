package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Club;
import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Entities.Enseignant;
import com.kadem.kadem.Entities.Module;

import java.util.List;

public interface ModuleServiceInterface {
    public List<Module> getListeModules();
    public Module getModuleById(Long id);
    public String addModule(Module M);
    public Module updateModule(Long id , Module M);
    public void deleteModule(Long id);
    public List<Module> getModuleByDepName(String NomDep);

    public Module addModuleToDepartement(String NomDep, Module module);

    public List<Club> FindClubByDepAndUnivName (String nomUniv, String nomDepart);

    public List<Enseignant> triEnseignantByExp(Long idUniversite, Long idDepartement, Long idModule);
}
