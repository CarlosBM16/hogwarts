package com.carlos.hogwarts.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@Entity
@Table(name = "asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_asignatura;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "aula")
    private String aula;

    @Column(name = "obligatoria")
    private boolean obligatoria;

    @OneToOne(mappedBy = "asignatura")
    @JsonBackReference
    private Profesor profesor;

    @JsonIgnore
    @OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL)
    private List<EstudianteAsignatura> calificaciones;
}
