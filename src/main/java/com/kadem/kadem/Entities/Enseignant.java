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
    public Long id_Enseignant;
    public String nom_Enseignant;
    public String prenom_Enseignant;
    public String domaine;
    @JsonIgnore
    @ManyToOne
    public Universite universite;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "enseignant")
    private List<Equipe> equipes;

}
