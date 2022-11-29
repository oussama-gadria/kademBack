package com.kadem.kadem.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode

public class Evenement  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idEvenement;

    private String nomEvenement;

    @Temporal(TemporalType.DATE)
    private Date dateEvenement;

    private String emplacementEvenement;

    @ManyToOne
    @JsonIgnore
    private Club club;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Equipe> equipes;
}
