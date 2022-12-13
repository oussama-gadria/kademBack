package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Administrateur;
import com.kadem.kadem.Entities.Etudiant;

import java.util.List;

public interface AdministrateurServiceInterface {

    Administrateur addAdmin(Administrateur A);

    Administrateur updateAdmin(Long Id, Administrateur A);

    Administrateur GetAdminById(Long Id);


}
