package com.kadem.kadem.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity

@Table( name = "Equipe")

public class Equipe implements Serializable {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idEquipe;

    private String nomEquipe;

    private Long score;

    private Long responsable;

    @Enumerated(EnumType.STRING)

    private Niveau niveau;
    @JsonIgnore
    @ManyToOne
    Enseignant enseignant;
    @JsonIgnore
    @OneToOne
    private DetailEquipe detailEquipe;
    @JsonIgnore
    @JsonIgnoreProperties("equipes")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy="equipes")
    private List<Evenement> evenements;


}
