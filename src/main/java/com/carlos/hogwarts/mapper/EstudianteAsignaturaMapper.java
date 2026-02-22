package com.carlos.hogwarts.mapper;

import org.springframework.stereotype.Component;

import com.carlos.hogwarts.dtos.response.EstudianteAsignaturaDTO;
import com.carlos.hogwarts.model.EstudianteAsignatura;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Data
public class EstudianteAsignaturaMapper {
    public EstudianteAsignaturaDTO toDto(EstudianteAsignatura estAsig) {
        if (estAsig == null) return null;

        EstudianteAsignaturaDTO dto = new EstudianteAsignaturaDTO();
        dto.setAsignatura(estAsig.getAsignatura().getNombre());
        dto.setCalificacion(estAsig.getCalificacion());

        return dto;
    }
}
