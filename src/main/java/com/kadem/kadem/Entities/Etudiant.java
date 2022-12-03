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

    private String nomE;

    private String prenomE;

    private String email;

    private String password ;

    private String confirmPassword;

    private String numeroTelephone;

    private String adresse;

    private String age;

    private int classe;
    private int  niveauEtudiant;


    @Enumerated(EnumType.STRING)
    private Option option;


    private Float moyenneE;

    @JsonIgnoreProperties("etudiant")
    @OneToMany(mappedBy="etudiant",cascade=CascadeType.ALL)
    private List<Contrat> contrats;


    @JsonIgnoreProperties("etudiants")
    @ManyToMany(mappedBy="etudiants",cascade=CascadeType.ALL)
    private List<Equipe> equipes;


    @JsonIgnoreProperties("etudiants")
    @ManyToOne
    private Departement departement;


    @JsonIgnoreProperties("etudiantsclub")
    @ManyToMany(mappedBy="etudiantsclub",cascade=CascadeType.ALL)
    private List<Club> clubs;


}



