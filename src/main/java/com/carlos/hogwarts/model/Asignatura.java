package com.carlos.hogwarts.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @EqualsAndHashCode.Exclude  // <--- INDISPENSABLE
    @ToString.Exclude           // <--- EVITA ERRORES EN CONSOLA
    private Profesor profesor;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
        name = "estudiante_asignatura",
        joinColumns = @JoinColumn(name = "id_asignatura"),
        inverseJoinColumns = @JoinColumn(name = "id_estudiante")
    )
    private List<Estudiante> estudiantes;
}
