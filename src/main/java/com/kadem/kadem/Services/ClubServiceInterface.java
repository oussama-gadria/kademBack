package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Club;
import com.kadem.kadem.ExceptionHandlingClubEvent.InvalidExceptionClubEvent;

import java.util.List;

public interface ClubServiceInterface {

    List<Club> GetAllClubs();

    Club addClub(Club club);

    Club updateClub (Long Id,Club cl );

    Club GetClubById (Long Id);

    void DeleteClub (Long Id);

    Club addClubWithResponsable (Club club ,  String nomEtudiant , String prenomEtudiant , String emailEtudiant ) throws InvalidExceptionClubEvent;

    Club assignEtudiantToClub(String nom, String prenom, String email, Long idClub);

    public List<Club> GetClubsByIdEtudiant(Long idEtudiant) ;

    public Club assignEtudiantToClubbyId(Long id,Long idClub);



}
