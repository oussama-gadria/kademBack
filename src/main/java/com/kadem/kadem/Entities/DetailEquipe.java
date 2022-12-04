package com.kadem.kadem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

@Table( name = "DetailEquipe")

public class DetailEquipe implements Serializable {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer salle;

    private String thematique;
    @JsonIgnore
    @OneToOne(mappedBy = "detailEquipe")
    private Equipe equipe;
}

