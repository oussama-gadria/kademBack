package com.kadem.kadem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModule;
    private String nomModule;
    private Integer nbrMatieres;

    @OneToOne
    @JsonIgnore
    private RespModule respModule;
    @ManyToOne
    private Departement departement;
}
