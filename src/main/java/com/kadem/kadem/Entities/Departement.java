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

public class Departement implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepart;
    private String nomDepart;

    @Enumerated(EnumType.STRING)
    private BLOC bloc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
    private List<Module> modules;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
    private List<Etudiant> etudiants;

}
