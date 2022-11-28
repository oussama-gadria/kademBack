package com.kadem.kadem.Controlleur;

import com.kadem.kadem.Entities.BLOC;
import com.kadem.kadem.Entities.RespModule;
import com.kadem.kadem.Services.RespModuleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RespModule")
public class RespModuleControlleur {

    @Autowired
    private RespModuleServiceInterface RespDepartService;


    @PostMapping("/addRespModule")
    public String addRespModule (@RequestBody() RespModule R)
    {
        return RespDepartService.addRespModule(R);
    }

    @GetMapping("/getAllRespModules")
    public List<RespModule> getAllRespModules()
    {
        return RespDepartService.getListeRespModules();
    }


    @GetMapping("/getRespModuleById/{id}")
    public RespModule getRespModuleById(@PathVariable("id") Long id)
    {
        return RespDepartService.getRespModuleById(id);
    }

    @PutMapping("/updateRespModule/{id}")
    public RespModule updateRespModule(@PathVariable("id")Long id, @RequestBody() RespModule R )
    {
        return RespDepartService.updateRespModule(id,R);
    }

    @DeleteMapping("/deleteRespModule/{id}")
    public void deleteRespModule (@PathVariable("id") Long id)
    {

        RespDepartService.deleteRespModule(id);
    }


    @PostMapping("/addRespToModule/{nomModule}")
    public RespModule addRespToModule(@RequestBody() RespModule R, @PathVariable("nomModule") String nomModule)
    {
        return RespDepartService.addRespToModule(R,nomModule);
    }




}
