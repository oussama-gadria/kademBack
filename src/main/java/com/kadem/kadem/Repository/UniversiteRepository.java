package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Universite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository extends CrudRepository<Universite,Long> {
}
