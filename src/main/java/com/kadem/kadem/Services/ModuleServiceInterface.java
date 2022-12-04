package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Entities.Module;

import java.util.List;

public interface ModuleServiceInterface {
    public List<Module> getListeModules();
    public Module getModuleById(Long id);
    public String addModule(Module M);
    public Module updateModule(Long id , Module M);
    public void deleteModule(Long id);

}
