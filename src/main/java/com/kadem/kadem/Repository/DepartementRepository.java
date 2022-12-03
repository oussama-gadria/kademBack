package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.BLOC;
import com.kadem.kadem.Entities.Departement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository     extends CrudRepository<Departement,Long>{

    Departement findByNomDepart(String nomDepartement);
    }
