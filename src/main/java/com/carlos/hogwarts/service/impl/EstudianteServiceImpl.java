package com.carlos.hogwarts.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carlos.hogwarts.dtos.EstudianteDTO;
import com.carlos.hogwarts.mapper.EstudianteMapper;
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
}
