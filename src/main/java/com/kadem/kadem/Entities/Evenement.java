package com.kadem.kadem.Entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    private Club club;

}
