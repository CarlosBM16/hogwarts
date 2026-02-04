package com.carlos.hogwarts.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carlos.hogwarts.dtos.request.create.EstudianteCreateDTO;
import com.carlos.hogwarts.dtos.response.EstudianteDTO;
import com.carlos.hogwarts.mapper.EstudianteMapper;
import com.carlos.hogwarts.model.Estudiante;
import com.carlos.hogwarts.repository.EstudianteRepository;
import com.carlos.hogwarts.service.EstudianteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper;

    @Override
    public List<EstudianteDTO> obtenerTodos() {
        return estudianteRepository.findAll()
            .stream()
            .map(estudianteMapper::toDto)
            .toList();
    }

    @Override
    public EstudianteDTO crearEstudiante(EstudianteCreateDTO dto) {
        Estudiante estudiante = estudianteMapper.toEntity(dto);
        
    }
}
