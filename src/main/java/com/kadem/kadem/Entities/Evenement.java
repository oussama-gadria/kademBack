package com.kadem.kadem.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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




    @JsonIgnoreProperties("evenements")
    @ManyToOne
    private Club club;

    @JsonIgnoreProperties("evenements")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Equipe> equipes;


}
