package com.kadem.kadem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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


    @JsonIgnoreProperties("modules")
    @ManyToOne
    private Departement departement;

    @JsonIgnoreProperties("module")
    @OneToMany( mappedBy="module")
    private List<Enseignant> listEnseignant;
}
