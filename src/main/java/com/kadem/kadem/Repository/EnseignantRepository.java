package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Enseignant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends CrudRepository<Enseignant,Long>{

}
