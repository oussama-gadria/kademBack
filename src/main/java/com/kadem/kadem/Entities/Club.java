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

public class Club  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idClub;

    private String nomClub;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="club")
    private List<Evenement> evenements;
}
