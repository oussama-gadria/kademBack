package com.kadem.kadem.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_universite;
    public String nom_universite;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "universite")
    private List<Enseignant> enseignant;
   /* @OneToMany(cascade = CascadeType.ALL)
    private List<Departement> departements;*/
}
