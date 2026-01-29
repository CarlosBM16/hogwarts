package com.carlos.hogwarts.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.carlos.hogwarts.dtos.AsignaturaDTO;
import com.carlos.hogwarts.dtos.EstudianteDTO;
import com.carlos.hogwarts.model.Estudiante;

@Component
public class EstudianteMapper {
    public EstudianteDTO toDto(Estudiante estudiante) {
        EstudianteDTO dto = new EstudianteDTO();

        dto.setId(estudiante.getId_estudiante());
        dto.setNombre(estudiante.getNombre());
        dto.setAnyoCurso(estudiante.getAnyo_curso());
        dto.setFechaNacimiento(estudiante.getFecha_nacimiento().toLocalDate());
        dto.setCasa(estudiante.getCasa().getNombre());
        dto.setMascota(new MascotaMapper().toDto(estudiante.getMascota()));
        
        List<AsignaturaDTO> listaAsignaturas = estudiante.getAsignaturas().stream()
            .map(asignatura -> {
                AsignaturaDTO dto2 = new AsignaturaDTO();
                dto2.setId(asignatura.getId_asignatura());
                dto2.setNombre(asignatura.getNombre());
                dto2.setAula(asignatura.getAula());
                dto2.setObligatoria(asignatura.isObligatoria());
                dto2.setProfesor(asignatura.getProfesor().getNombre());

                return dto2;
            })
            .collect(Collectors.toList());

        dto.setAsignaturas(listaAsignaturas);

        return dto;
    }
}
