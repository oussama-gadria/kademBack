package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Contrat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratRepository extends CrudRepository<Contrat,Long> {


    ///find contrat by archive
     public Contrat findAllByArchive(Boolean archive);

    ///find contrat by dateDebut et dateFin

    public List<Contrat> findByDateDebutContratAfterAndDateFinContratBefore(Date startDate, Date endDate);
}
