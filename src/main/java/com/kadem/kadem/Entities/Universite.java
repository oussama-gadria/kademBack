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
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_universite;
    public String nom_universite;
    @OneToMany
    private List<Enseignant> enseignant;
}
