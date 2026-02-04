package com.carlos.hogwarts.dtos.response;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class EstudianteDTO {
    private long id;
    private String nombre;
    private int anyoCurso;
    private LocalDate fechaNacimiento;
    private String casa;
    private MascotaDTO mascota;
    private List<AsignaturaDTO> asignaturas;
}
