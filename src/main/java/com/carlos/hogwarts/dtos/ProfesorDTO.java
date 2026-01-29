package com.carlos.hogwarts.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProfesorDTO {
    private long id;
    private String nombre;
    private String asignatura;
    private LocalDate fechaInicio;
}
