package com.kadem.kadem.Services;



import com.kadem.kadem.Entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {
    public List<DetailEquipe> getListeDetailEquipes();
    public DetailEquipe getDetailEquipeById(int id);
    public DetailEquipe addDetailEquipe(DetailEquipe DE);
    public DetailEquipe updateDetailEquipe(int id , DetailEquipe DE);
    public String deleteDetailEquipe(int id);
    public String DetailEquipeWithEquipe(Long IdEquipe, DetailEquipe DE);


}
