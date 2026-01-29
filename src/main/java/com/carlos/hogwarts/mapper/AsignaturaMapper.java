package com.carlos.hogwarts.mapper;

import com.carlos.hogwarts.dtos.AsignaturaDTO;
import com.carlos.hogwarts.model.Asignatura;

public class AsignaturaMapper {
    public AsignaturaDTO toDto(Asignatura asignatura) {
        AsignaturaDTO dto = new AsignaturaDTO();

        dto.setId(asignatura.getId_asignatura());
        dto.setNombre(asignatura.getNombre());
        dto.setAula(asignatura.getAula());
        dto.setObligatoria(asignatura.isObligatoria());
        dto.setProfesor(asignatura.getProfesor().getNombre());

        return dto;
    }
}
