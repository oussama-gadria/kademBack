package com.kadem.kadem.Repository;


import com.kadem.kadem.Entities.Evenement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends CrudRepository<Evenement,Long> {
}
