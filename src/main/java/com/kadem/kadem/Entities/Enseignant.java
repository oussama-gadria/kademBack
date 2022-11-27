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
    public Long idEnseignant;
    public String nomEnseignant;
    public String prenomEnseignant;
    public String nomDepartement;
    public Float salaire;
    public Integer experienceParAnnee;
    @JsonIgnore
    @ManyToOne
    public Universite universite;
}
