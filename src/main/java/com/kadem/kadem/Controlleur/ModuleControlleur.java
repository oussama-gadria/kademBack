package com.kadem.kadem.Controlleur;

import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Entities.Module;
import com.kadem.kadem.Services.DepartementServiceInterface;
import com.kadem.kadem.Services.ModuleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Module")
public class ModuleControlleur {
    @Autowired
    private ModuleServiceInterface ModuleService;


    @PostMapping("/addModule")
    public String addModule (@RequestBody() Module M)
    {
        return ModuleService.addModule(M);
    }

    @GetMapping("/getAllModules")
    public List<Module> getListeModules() {return ModuleService.getListeModules();}


    @GetMapping("/getModuleById/{id}")
    public Module getModuleById(@PathVariable("id") Long id)
    {
        return ModuleService.getModuleById(id);
    }

    @PutMapping("/updateModule/{id}")
    public Module updateModule(@PathVariable("id")Long id,  @RequestBody() Module M )
    {
        return ModuleService.updateModule(id,M);
    }

    @DeleteMapping("/deleteModule/{id}")
    public void deleteModule (@PathVariable("id") Long id)
    {
        ModuleService.deleteModule(id);
    }


}
