package com.kadem.kadem.Entities;


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

    private String nomEtudiant;
    private String prenomEtudiant;

    private  String Username;

    private String Email;

    private String password;

    private String confirmPassword;

    private String numeroTelephone;

    private String adresse;

    @Enumerated(EnumType.STRING)
    private NiveauEtudiant niveauEtudiant;











    @Enumerated(EnumType.STRING)
    private Option option;



    @OneToMany(cascade = CascadeType.ALL, mappedBy="etudiant")
    private List<Contrat> contrats;

    @ManyToMany(mappedBy="etudiants",cascade=CascadeType.ALL)
    private List<Equipe> equipes;

    @ManyToOne
    private Departement departement;

}



