package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Universite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface UniversiteRepository extends CrudRepository<Universite,Long> {
    Universite findByNomUniversite(String nomUniversite);
}
