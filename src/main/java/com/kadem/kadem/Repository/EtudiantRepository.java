package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Etudiant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant,Long> {

    public Etudiant findByNomEAndPrenomE(String nom,String prenom);
    public Etudiant findByNomEAndPrenomEAndEmail(String nom,String prenom, String email);


}
