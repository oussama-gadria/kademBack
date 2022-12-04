package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.Enseignant;
import com.kadem.kadem.Entities.Etudiant;
import com.kadem.kadem.Entities.Option;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant,Long> {


    @Query("select etudiant from Etudiant etudiant where etudiant.prenomE=?1 and etudiant.nomE=?2")
    public Etudiant getEtudiantByNomAndPrenom(String prenom, String nom);

    public Etudiant findByNomEAndPrenomE(String nom,String prenom);
    public Etudiant findByNomEAndPrenomEAndEmail(String nom,String prenom, String email);

    public Etudiant findByEmail(String email);

    //public List<Etudiant> findByDepartementIdDepartAndClasseAndNiveauEtudiantAndOption(Long idDepartment, int classe, int niveau, Option option);
     public List<Etudiant> findByDepartement_IdDepartAndClasseAndNiveauEtudiantAndOptionOrderByMoyenneEDesc(Long idDepartment, Integer classe, Integer niveau, Option option);

    @Query("select enseignant from Enseignant enseignant join Module module on enseignant member module.listEnseignant join Departement  departement on module member departement.modules join Etudiant etudiant on etudiant member departement.etudiants where etudiant.idEtudiant=?1 group by module.nomModule")
    public List<Enseignant> getEnseignantsByIdEtudiantGroupByModule(Long idEtudiant);

}
