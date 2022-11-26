package com.kadem.kadem.Entities;

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
public class RespDepart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRespDepart;
    private String nomRespDepart;
    private String prenomRespDepart;

    @OneToOne(cascade = CascadeType.ALL, mappedBy="RD")
    private Departement D;

}
