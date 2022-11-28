package com.kadem.kadem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RespModule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRespModule;
    private String nomRespModule;
    private String prenomRespModule;
    private String emailResp;

    private String nomMatiereResp;
    private Integer ageResp;

    private Float salaireResp;

    private Integer experienceAnnuelle;



@OneToOne(cascade = CascadeType.ALL, mappedBy="respModule")
    private Module module;

}
