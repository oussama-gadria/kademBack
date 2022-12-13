package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Administrateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Administrateur,Long> {
}
