package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.DetailEquipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("*")
public interface DetailEquipeRepository extends CrudRepository<DetailEquipe, Integer> {

}
