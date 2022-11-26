package com.kadem.kadem.Services;



import com.kadem.kadem.Entities.Equipe;

import java.util.List;

public interface IEquipeService {
    public List<Equipe> getListeEquipes();
    public Equipe getEquipeById(Long id);
    public Equipe addEquipe(Equipe E);
    public Equipe updateEquipe(Long id , Equipe E);
    public String deleteEquipe(Long id);
    public Equipe addEquipeWithDetailEquipe(int IdDE, Equipe E);


}
