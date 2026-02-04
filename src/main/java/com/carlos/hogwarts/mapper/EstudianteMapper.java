package com.carlos.hogwarts.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.carlos.hogwarts.dtos.request.create.EstudianteCreateDTO;
import com.carlos.hogwarts.dtos.response.AsignaturaDTO;
import com.carlos.hogwarts.dtos.response.EstudianteDTO;
import com.carlos.hogwarts.model.Estudiante;
import com.carlos.hogwarts.repository.CasaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Data
@RequiredArgsConstructor
public class EstudianteMapper {
    private final CasaRepository casaRepository;

    public EstudianteDTO toDto(Estudiante estudiante) {
        if (estudiante == null) return null;

        EstudianteDTO dto = new EstudianteDTO();

        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre());
        dto.setAnyoCurso(estudiante.getAnyo_curso());
        dto.setFechaNacimiento(estudiante.getFecha_nacimiento().toLocalDate());
        dto.setCasa(estudiante.getCasa().getNombre());
        dto.setMascota(mascotaMapper.toDto(estudiante.getMascota()));
        
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

    public Estudiante toEntity(EstudianteCreateDTO dto) {
        if (dto == null) return null;

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setAnyo_curso(dto.getAnyoCurso());
        estudiante.setCasa(
            casaRepository.findById(
                estudiante.getCasa()
                          .getId_casa()
            ).orElseThrow(() -> new RuntimeException("La casa no se ha encontrado")));
        estudiante.setMascota(dto.getMascota());
        return estudiante;
    }
}
