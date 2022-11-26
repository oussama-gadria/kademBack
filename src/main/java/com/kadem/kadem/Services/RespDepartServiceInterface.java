package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.RespDepart;

import java.util.List;

public interface RespDepartServiceInterface {

    public List<RespDepart> getListeRespDeparts();
    public RespDepart getRespDepartById(Long id);
    public String addRespDepart(RespDepart R);
    public  RespDepart updateRespDepart(Long id , RespDepart R);

    public void deleteRespDepart(Long id);
}
