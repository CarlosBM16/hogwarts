package com.carlos.hogwarts.services;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.carlos.hogwarts.model.Casa;
import com.carlos.hogwarts.model.Estudiante;
import com.carlos.hogwarts.repository.EstudianteRepository;
import com.carlos.hogwarts.service.impl.EstudianteServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EstudianteServiceTest {
    @Mock
    private EstudianteRepository estudianteRepository;

    @InjectMocks
    private EstudianteServiceImpl estudianteService;

    private Estudiante estudianteTest;

    @BeforeEach
    void setUp() {
        estudianteTest = new Estudiante();
        estudianteTest.setId(1L);
        estudianteTest.setCasa(new Casa());
        estudianteTest.setNombre("estudiante_test");
        estudianteTest.setApellido("apellido");
        estudianteTest.setMascota(null);
        estudianteTest.setCalificaciones(new ArrayList<>());
    }

    @Test
    void eliminar_Estudiante() {
        Long id = 1L;

        when(estudianteRepository.findById(id)).thenReturn(Optional.of(estudianteTest));

        estudianteService.eliminarEstudiante(id);

        verify(estudianteRepository, times(1)).deleteById(estudianteTest.getId());
    }

}
