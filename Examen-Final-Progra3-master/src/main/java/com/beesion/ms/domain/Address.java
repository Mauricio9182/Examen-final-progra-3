package com.beesion.ms.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

    private String country;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;


    /* Esta clase representa una dirección asociada a una persona.
     Se usa @ManyToOne para enlazar cada Address con una entidad Person.*/
}
