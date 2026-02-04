package com.carlos.hogwarts.mapper;

import com.carlos.hogwarts.dtos.response.ProfesorDTO;
import com.carlos.hogwarts.model.Profesor;

public class ProfesorMapper {
    public ProfesorDTO toDto(Profesor profesor) {
        ProfesorDTO dto = new ProfesorDTO();

        dto.setId(profesor.getId_profesor());
        dto.setNombre(profesor.getNombre());
        dto.setAsignatura(profesor.getAsignatura().getNombre());
        dto.setFechaInicio(profesor.getFecha_inicio().toLocalDate());

        return dto;
    }
}
