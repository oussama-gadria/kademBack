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
    @JsonIgnore
    @ManyToOne
    private Module module;

}
