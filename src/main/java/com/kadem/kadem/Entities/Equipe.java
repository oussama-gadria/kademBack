package com.kadem.kadem.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity

@Table( name = "Equipe")

public class Equipe implements Serializable {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="idEquipe")

    private Long idEquipe;

    private String nomEquipe;

    @Enumerated(EnumType.STRING)

    private Niveau niveau;

    @OneToOne(cascade = CascadeType.ALL, mappedBy="equipe")
    private DetailEquipe detailEquipe;

}
