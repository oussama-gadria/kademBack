package com.kadem.kadem.Entities;


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
@EqualsAndHashCode

public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String prenomE;
    private String nomE;

    @Enumerated(EnumType.STRING)
    private Option option;



    @OneToMany(cascade = CascadeType.ALL, mappedBy="etudiant")
    private List<Contrat> contrats;




}



