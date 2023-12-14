package com.cis.dass21.domain.participant.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "Participantes")
@Data
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String name;

    @Column(name = "idade", nullable = false)
    private Integer age;

    @Column(name = "genero", length = 20, nullable = false)
    private String gender;
}