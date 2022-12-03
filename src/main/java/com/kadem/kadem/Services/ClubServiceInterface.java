package com.kadem.kadem.Services;

import com.kadem.kadem.Entities.Club;

import java.util.List;

public interface ClubServiceInterface {

    List<Club> GetAllClubs();

    Club addClub(Club club);

    Club updateClub (Long Id,Club cl );

    Club GetClubById (Long Id);

    void DeleteClub (Long Id);




}
