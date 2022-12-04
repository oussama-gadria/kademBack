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

public class Departement implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepart;
    private String nomDepart;

    @Enumerated(EnumType.STRING)
    private BLOC bloc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
    private List<Module> modules;

    @JsonIgnoreProperties("departement")
    @OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
    private List<Etudiant> etudiants;

}
