package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.DetailEquipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailEquipeRepository extends CrudRepository<DetailEquipe, Integer> {

}
