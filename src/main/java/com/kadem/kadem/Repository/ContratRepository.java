package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Contrat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends CrudRepository<Contrat,Long> {

}
