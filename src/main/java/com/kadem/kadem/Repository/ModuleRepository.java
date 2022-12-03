package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.BLOC;
import com.kadem.kadem.Entities.Departement;
import com.kadem.kadem.Entities.Module;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends CrudRepository<Module,Long> {
    public Module findByNomModule(String nomModule);
}
