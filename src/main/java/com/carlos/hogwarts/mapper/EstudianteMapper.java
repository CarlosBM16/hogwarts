package com.carlos.hogwarts.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.carlos.hogwarts.dtos.request.create.EstudianteCreateDTO;
import com.carlos.hogwarts.dtos.request.update.EstudianteUpdateDTO;
import com.carlos.hogwarts.dtos.response.AsignaturaDTO;
import com.carlos.hogwarts.dtos.response.EstudianteDTO;
import com.carlos.hogwarts.model.Estudiante;
import com.carlos.hogwarts.repository.CasaRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Data
public class EstudianteMapper {
    private final CasaRepository casaRepository;
    private final MascotaMapper mascotaMapper;
    private final EstudianteAsignaturaMapper estudianteAsignaturaMapper;

    public EstudianteDTO toDto(Estudiante estudiante) {
        if (estudiante == null) return null;

        EstudianteDTO dto = new EstudianteDTO();

        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre());
        dto.setAnyoCurso(estudiante.getAnyo_curso());
        dto.setFechaNacimiento(estudiante.getFecha_nacimiento());
        dto.setCasa(estudiante.getCasa().getNombre());

        if (estudiante.getMascota() != null) {
            dto.setMascota(mascotaMapper.toDto(estudiante.getMascota()));
        } else {
            dto.setMascota(null);
        }
 
        
        if (estudiante.getCalificaciones() != null) {
            dto.setAsignaturas(estudiante.getCalificaciones().stream()
                .map(a -> estudianteAsignaturaMapper.toDto(a))
                .toList()
            );
        } else {
            dto.setAsignaturas(null);
        }

        

        return dto;
    }

    public Estudiante toEntity(EstudianteCreateDTO dto) {
        if (dto == null) return null;

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setAnyo_curso(dto.getAnyoCurso());
        estudiante.setFecha_nacimiento(dto.getFechaNacimiento());

        if (dto.getCasaId() != null) {
            estudiante.setCasa(
                casaRepository.findById(dto.getCasaId())
                .orElseThrow(() -> new RuntimeException("La casa no se ha encontrado"))     
            );
        }

        estudiante.setMascota(mascotaMapper.toEntity(dto.getMascota()));
        
        return estudiante;
    }

    public void updateEntityFromDto(EstudianteUpdateDTO dto, Estudiante estudiante) {
        if (dto == null || estudiante == null) return;

        estudiante.setAnyo_curso(dto.getAnyoCurso());
        estudiante.setFecha_nacimiento(dto.getFechaNacimiento());
        mascotaMapper.updateEntityFromDto(dto.getMascota(), estudiante.getMascota());
    }
}
