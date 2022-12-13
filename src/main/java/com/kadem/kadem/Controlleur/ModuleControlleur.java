package com.kadem.kadem.Controlleur;

import com.kadem.kadem.Entities.Club;
import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Entities.Enseignant;
import com.kadem.kadem.Entities.Module;
import com.kadem.kadem.Services.DepartementServiceInterface;
import com.kadem.kadem.Services.ModuleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/Module")
public class ModuleControlleur {
    @Autowired
    private ModuleServiceInterface moduleService;




    @PostMapping("/addModule")
    public String addModule (@RequestBody() Module M)
    {
        return moduleService.addModule(M);
    }

    @GetMapping("/getAllModules")
    public List<Module> getListeModules() {return moduleService.getListeModules();}


    @GetMapping("/getModuleById/{id}")
    public Module getModuleById(@PathVariable("id") Long id)
    {
        return moduleService.getModuleById(id);
    }

    @PutMapping("/updateModule/{id}")
    public Module updateModule(@PathVariable("id")Long id,  @RequestBody() Module M )
    {
        return moduleService.updateModule(id,M);
    }

    @DeleteMapping("/deleteModule/{id}")
    public void deleteModule (@PathVariable("id") Long id)
    {
        moduleService.deleteModule(id);
    }

    @GetMapping("/getModuleByDepName/{NomDep}")
    public List<Module> getModuleByDepName (@PathVariable("NomDep") String NomDep)
    {
        return moduleService.getModuleByDepName(NomDep);
    }

    @PostMapping("/addmoduletodepartement/{NomDep}")
    public Module attdepartementtomodule(@PathVariable("NomDep") String NomDep,@RequestBody() Module module)
    {
        return moduleService.addModuleToDepartement(NomDep,module);
    }

    @GetMapping("/FindClubByDepAndUnivName/{nomUniv}/{nomDepart}")
    List<Club> FindClubByDepAndUnivName (@PathVariable("nomUniv") String nomUniv, @PathVariable("nomDepart") String nomDepart )
    {
        return moduleService.FindClubByDepAndUnivName(nomUniv,nomDepart);
    }

    @GetMapping("/triEnseignantByExp/{idUniversite}/{idDepartement}/{idModule}")
    public  List<Enseignant> triEnseignantByExp(@PathVariable("idUniversite")Long idUniversite, @PathVariable("idDepartement") Long idDepartement , @PathVariable("idModule") Long idModule)
    {
        return moduleService.triEnseignantByExp(idUniversite,idDepartement,idModule);
    }

}
