package com.carlos.hogwarts.dtos.request.update;

import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EstudianteUpdateDTO {
    @NotNull(message = "El año del curso es obligatorio.")
    private int anyoCurso;

    @NotNull(message = "La fecha es obligatorio.")
    private LocalDate fechaNacimiento;

    @Valid
    private MascotaUpdateDto mascota;
}
