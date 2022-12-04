package com.kadem.kadem.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode

public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String prenomE;
    private String nomE;

    private String email;

    @Enumerated(EnumType.STRING)
    private Option option;


    @ManyToMany(mappedBy="etudiants",cascade=CascadeType.ALL)
    private List<Equipe> equipes;

    @ManyToOne
    private Departement departement;

    @JsonIgnoreProperties("etudiantsclub")
      @ManyToMany(mappedBy="etudiantsclub",cascade=CascadeType.ALL)
    private List<Club> clubs;

    @JsonIgnoreProperties("ResponsableClub")
    @OneToMany (mappedBy="ResponsableClub",cascade=CascadeType.ALL)
    private List<Club> clubsResponsable;


}



