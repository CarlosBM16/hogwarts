package com.carlos.hogwarts.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EstudianteAsignaturaKey implements Serializable {
    @Column(name = "id_estudiante")
    private Long id_estudiante;

    @Column(name = "id_asignatura")
    private Long id_asignatura;
}
