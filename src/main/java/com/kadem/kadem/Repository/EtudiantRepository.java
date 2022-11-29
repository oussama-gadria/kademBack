package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Etudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant,Long> {
    @Query("select etudiant from Etudiant etudiant where etudiant.prenomE=?1 and etudiant.nomE=?2")
    public Etudiant getEtudiantByNomAndPrenom(String prenom, String nom);
    //Etudiant findEtudiantByNomEAndPrenomE(String prenom,String nom);
}
