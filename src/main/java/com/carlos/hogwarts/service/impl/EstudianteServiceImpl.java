package com.carlos.hogwarts.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.carlos.hogwarts.dtos.request.create.EstudianteCreateDTO;
import com.carlos.hogwarts.dtos.request.update.EstudianteUpdateDTO;
import com.carlos.hogwarts.dtos.response.EstudianteDTO;
import com.carlos.hogwarts.mapper.EstudianteMapper;
import com.carlos.hogwarts.mapper.MascotaMapper;
import com.carlos.hogwarts.model.Estudiante;
import com.carlos.hogwarts.model.Mascota;
import com.carlos.hogwarts.repository.CasaRepository;
import com.carlos.hogwarts.repository.EstudianteRepository;
import com.carlos.hogwarts.service.EstudianteService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper;
    private final CasaRepository casaRepository;
    private final MascotaMapper mascotaMapper;

    @Override
    public List<EstudianteDTO> obtenerTodos() {
        return estudianteRepository.findAll()
            .stream()
            .map(estudianteMapper::toDto)
            .toList();
    }

    @Override
    public EstudianteDTO obtenerEstudiantePorId(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Estudiante con id " + id + " no encontrado"));
        
        return estudianteMapper.toDto(estudiante);
    }

    @Override
    @Transactional
    public EstudianteDTO crearEstudiante(EstudianteCreateDTO dto) {
        Estudiante estudiante = estudianteMapper.toEntity(dto);

        if (estudiante.getMascota() != null) {
            estudiante.getMascota().setEstudiante(estudiante);
        }

        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);

        return estudianteMapper.toDto(estudianteGuardado);
    }

    @Override
    @Transactional
    public EstudianteDTO actualizarEstudiante(Long id, EstudianteUpdateDTO dto) {
        Estudiante estudianteExistente = estudianteRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado con id: " + id));

        estudianteMapper.updateEntityFromDto(dto, estudianteExistente);

        if (dto.getMascota() != null) {
            if (estudianteExistente.getMascota() == null) {
                Mascota nuevaMascota = new Mascota();
                mascotaMapper.updateEntityFromDto(dto.getMascota(), nuevaMascota);
                
                nuevaMascota.setEstudiante(estudianteExistente); 
                estudianteExistente.setMascota(nuevaMascota); 
            } else {
                mascotaMapper.updateEntityFromDto(dto.getMascota(), estudianteExistente.getMascota());
            }
        }

        Estudiante estudianteActualizado = estudianteRepository.save(estudianteExistente);

        return estudianteMapper.toDto(estudianteActualizado);
    }

    @Override
    @Transactional
    public void eliminarEstudiante(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("El estudiante con ID " + id + " no existe."));
            
        // Borra en cascasda
        estudianteRepository.deleteById(id); 
    }

}
