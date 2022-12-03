package com.kadem.kadem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Contrat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;

    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;

    @Enumerated(EnumType.STRING)
    private Specialite specialite ;

    private Boolean archive ;
    private Float montantC;


    @JsonIgnoreProperties("contrats")
    @ManyToOne
    private Etudiant etudiant;


}
