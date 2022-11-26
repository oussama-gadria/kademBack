package com.kadem.kadem.Controlleur;

import com.kadem.kadem.Entities.DetailEquipe;
import com.kadem.kadem.Services.IDetailEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/detailEquipe")
public class DetailEquipeController {
    @Autowired
    IDetailEquipeService detailEquipeService;

    @GetMapping("/get-detailEquipe")
    public List<DetailEquipe> getDetailEquipes(){
        List<DetailEquipe> listeDetailEquipes=detailEquipeService.getListeDetailEquipes();
        return listeDetailEquipes;
    }
    @GetMapping("/get-detailEquipe/{id}")
    public DetailEquipe getDetailEquipesById(@PathVariable("id")int id){
        return detailEquipeService.getDetailEquipeById(id);
    }
    @PostMapping("add-detailEquipe")
    public String addDetailEquipe(@RequestBody DetailEquipe de){
        DetailEquipe detailEquipe= detailEquipeService.addDetailEquipe(de);
        if(detailEquipe!=null){
            return "detailEquipe ajouter";
        }
        else{
            return "detailEquipe non ajouter";
        }
    }
    @DeleteMapping("/remove-detailEquipe/{id}")
    public String removeDetailEquipe(@PathVariable("id")int id){
        String result=detailEquipeService.deleteDetailEquipe(id);
        return result;
    }
    @PutMapping("/modify-detailEquipe/{id}")
    public DetailEquipe modifyDetailEquipe(@PathVariable("id")int id,@RequestBody DetailEquipe detailEquipe){
        DetailEquipe result= detailEquipeService.updateDetailEquipe(id,detailEquipe);
        return result;
    }

    @PostMapping("/addDetailEquipeWithEquipe/{id}")
    public  DetailEquipe addDetailEquipeWithEquipe(@PathVariable("id") Long id,  @RequestBody DetailEquipe de){
        return detailEquipeService.DetailEquipeWithEquipe(id,de);

    }



}
