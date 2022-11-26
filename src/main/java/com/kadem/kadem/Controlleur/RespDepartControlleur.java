package com.kadem.kadem.Controlleur;

import com.kadem.kadem.Entities.RespDepart;
import com.kadem.kadem.Services.RespDepartService;
import com.kadem.kadem.Services.RespDepartServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RespDepart")
public class RespDepartControlleur {

    @Autowired
    private RespDepartServiceInterface RespDepartService;


    @PostMapping("/addRespDepart")
    public String addRespDepart (@RequestBody() RespDepart R)
    {
        return RespDepartService.addRespDepart(R);
    }

    @GetMapping("/getAllRespDeparts")
    public List<RespDepart> getAllRespDeparts()
    {
        return RespDepartService.getListeRespDeparts();
    }


    @GetMapping("/getRespDepartById/{id}")
    public RespDepart getRespDepartById(@PathVariable("id") Long id)
    {
        return RespDepartService.getRespDepartById(id);
    }

    @PutMapping("/updateRespDepart/{id}")
    public RespDepart updateRespDepart(@PathVariable("id")Long id,  @RequestBody() RespDepart R )
    {
        return RespDepartService.updateRespDepart(id,R);
    }

    @DeleteMapping("/deleteRespDepart/{id}")
    public void deleteRespDepart (@PathVariable("id") Long id)
    {

        RespDepartService.deleteRespDepart(id);
    }


}
