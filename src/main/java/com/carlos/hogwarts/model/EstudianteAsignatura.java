package com.carlos.hogwarts.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante_asignatura")
public class EstudianteAsignatura {
    @EmbeddedId
    private EstudianteAsignaturaKey id;

    @ManyToOne
    @MapsId("id_estudiante")
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("id_asignatura")
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;

    private int calificacion;
}
