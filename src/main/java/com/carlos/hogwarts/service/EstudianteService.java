package com.carlos.hogwarts.service;

import java.util.List;

import com.carlos.hogwarts.dtos.request.create.EstudianteCreateDTO;
import com.carlos.hogwarts.dtos.response.EstudianteDTO;

public interface EstudianteService {
    List<EstudianteDTO> obtenerTodos();
    EstudianteDTO crearEstudiante(EstudianteCreateDTO dto);
    EstudianteDTO obtenerEstudiantePorId(Long id);
}
