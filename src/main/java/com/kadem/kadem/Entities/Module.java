package com.kadem.kadem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModule;
    private String nomModule;
    private Integer nbrMatieres;

    @ManyToOne
    private Departement departement;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="module")
    private List<Enseignant> listEnseignant;
}
