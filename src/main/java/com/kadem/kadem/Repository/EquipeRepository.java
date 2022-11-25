package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Equipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipeRepository extends CrudRepository<Equipe, Long> {
}
