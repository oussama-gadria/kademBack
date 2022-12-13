package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Departement;

import java.util.List;

public interface DepartementServiceInterface {
    public List<Departement> getListeDeparts();
    public Departement getDepartById(Long id);
    public String addDepart(Departement D);
    public Departement updateDepart(Long id , Departement D);
    public void deleteDepart(Long id);

    public Departement getDepartByname(String nomDepart);
}
