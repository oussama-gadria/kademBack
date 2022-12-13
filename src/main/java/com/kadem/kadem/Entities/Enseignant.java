package com.kadem.kadem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Enseignant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnseignant;
    private String nomEnseignant;
    private String prenomEnseignant;
    private String nomMatiere;
    private String email;
    private Integer age;
    private Float salaire;

    private Integer experienceParAnnee;

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="enseignant")
    private List<Equipe> equipes;

    @JsonIgnoreProperties("listEnseignant")
    @ManyToOne
    private Module module;


}
