package com.carlos.hogwarts.dtos.request.create;

import java.time.LocalDate;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import lombok.Data;

@Data
public class EstudianteCreateDTO {
    @NotBlank(message = "El nombre del estudiante no puede estar vacío")
    @Size(max = 50, message = "El nombre de estudiante no puede superar los 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido del estudiante no puede estar vacío")
    @Size(max = 50, message = "El apellido de estudiante no puede superar los 50 caracteres")
    private String apellido;

    @NotNull(message = "El año del curso es obligatorio")
    private int anyoCurso;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fechaNacimiento;

    @NotNull(message = "El id de la casa es obligatorio")
    private Long casaId;

    @Valid
    @NotNull(message = "La mascota es obligatoria")
    private MascotaCreateDTO mascota;
}