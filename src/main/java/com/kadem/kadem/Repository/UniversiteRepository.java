package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Evenement;
import com.kadem.kadem.Entities.Universite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversiteRepository extends CrudRepository<Universite,Long> {
    @Query("select  evenement from Evenement evenement join Club club on evenement member club.evenements join Etudiant etudiant on etudiant member club.etudiantsclub join Departement departement on etudiant member departement.etudiants join Universite universite on departement member universite.departements where universite.idUniversite=?1")
    List<Evenement> getlisteEvenementByIdUniversite(Long idUniversite);
    Universite findByNomUniversite(String nomUniversite);
}
