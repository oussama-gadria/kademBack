package com.kadem.kadem.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToMany(mappedBy="etudiants",cascade=CascadeType.ALL)
    private List<Equipe> equipes;


    @ManyToOne
    private Departement departement;


}



