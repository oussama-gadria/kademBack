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

    @Enumerated(EnumType.STRING)
    private Option option;


    @ManyToMany(mappedBy="etudiants",cascade=CascadeType.ALL)
    private List<Equipe> equipes;
    @JsonIgnoreProperties("etudiants")
    @ManyToOne
    private Departement departement;


    @ManyToMany(mappedBy="etudiantsclub",cascade=CascadeType.ALL)
    private List<Club> clubs;


}



