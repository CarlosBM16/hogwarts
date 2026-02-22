package com.carlos.hogwarts.service.impl;

import org.springframework.stereotype.Service;

import com.carlos.hogwarts.model.Asignatura;
import com.carlos.hogwarts.repository.AsignaturaRepository;
import com.carlos.hogwarts.service.AsignaturaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AsignaturaServiceImpl implements AsignaturaService {
    private final AsignaturaRepository asignaturaRepository;

    @Override
    public void eliminarAsignatura(Long id) {
        Asignatura asignatura = asignaturaRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("La asignatura con ID " + id + " no existe."));
            
        asignaturaRepository.deleteById(id);
    }
    
}
