package com.kadem.kadem.Controlleur;

import com.kadem.kadem.Entities.Equipe;
import com.kadem.kadem.Services.IEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/equipe")
public class EquipeController {
    @Autowired
    IEquipeService equipeService;

    @GetMapping("/get-equipe")
    public List<Equipe> getEquipes(){
        List<Equipe> listeEquipes=equipeService.getListeEquipes();
        return listeEquipes;
    }
    @GetMapping("/get-equipe/{id}")
    public Equipe getEquipesById(@PathVariable("id")Long id){
        return equipeService.getEquipeById(id);
    }
    @PostMapping("add-equipe")
    public String addEquipe(@RequestBody Equipe e){
        Equipe equipe= equipeService.addEquipe(e);
        if(equipe!=null){
            return "equipe ajouter";
        }
        else{
            return "equipe non ajouter";
        }
    }
    @DeleteMapping("/remove-equipe/{id}")
    public String removeEquipe(@PathVariable("id")Long id){
        String result=equipeService.deleteEquipe(id);
        return result;
    }
    @PutMapping("/modify-equipe/{id}")
    public Equipe modifyEquipe(@PathVariable("id")Long id,@RequestBody Equipe equipe){
        Equipe result= equipeService.updateEquipe(id,equipe);
        return result;
    }

    @PostMapping("/addEquipeWithDetailEquipe/{id}")
    public Equipe addEquipeWithDetailEquipe(@PathVariable("id") int id, @RequestBody Equipe e){
        return equipeService.addEquipeWithDetailEquipe(id,e);
    }
}