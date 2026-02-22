package com.carlos.hogwarts.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.*;

import com.carlos.hogwarts.controller.EstudianteController;
import com.carlos.hogwarts.controller.AsignaturaController;

import com.carlos.hogwarts.model.Estudiante;
import com.carlos.hogwarts.service.AsignaturaService;
import com.carlos.hogwarts.service.EstudianteService;

import tools.jackson.databind.ObjectMapper;


@WebMvcTest({EstudianteController.class, AsignaturaController.class})
public class EstudianteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean 
    private EstudianteService estudianteService;

    @MockitoBean
    private AsignaturaService asignaturaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void crearEstudiante_CursoInvalido_DebeRetornar400() throws Exception {
        Estudiante est = new Estudiante();
        est.setAnyo_curso(10); // Curso inválido

        mockMvc.perform(post("/api/estudiantes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(est)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void eliminarAsignatura_ConAlumnos_DebeRetornar409() throws Exception {
        Long idAsignatura = 1L;
        doThrow(new IllegalStateException("Tiene alumnos"))
                .when(asignaturaService).eliminarAsignatura(idAsignatura);

        mockMvc.perform(delete("/api/asignaturas/" + idAsignatura))
                .andExpect(status().isConflict());
    }
}
