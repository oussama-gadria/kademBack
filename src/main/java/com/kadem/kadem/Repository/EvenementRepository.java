package com.kadem.kadem.Repository;


import com.kadem.kadem.Entities.Evenement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EvenementRepository extends CrudRepository<Evenement,Long> {

    @Query("select e from Evenement e where e.dateEvenement>=?1 and e.dateEvenement<=?2" )
    List<Evenement> evenementBetween2dates(Date datedebut , Date datefin) ;
}
