package com.kadem.kadem.Entities;

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
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_Enseignant;
    public String nom_Enseignant;
    public String prenom_Enseignant;
    public String domaine;
    @OneToMany(mappedBy = "enseignant")
    public Universite universite;
}
