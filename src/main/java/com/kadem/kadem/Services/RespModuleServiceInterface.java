package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.BLOC;
import com.kadem.kadem.Entities.RespModule;

import java.util.List;

public interface RespModuleServiceInterface {

    public List<RespModule> getListeRespModules();
    public RespModule getRespModuleById(Long id);
    public String addRespModule(RespModule R);
    public RespModule updateRespModule(Long id , RespModule R);
    public void deleteRespModule(Long id);

    public RespModule addRespToModule(RespModule R, String nomModule);
}
