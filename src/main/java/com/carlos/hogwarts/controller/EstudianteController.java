package com.carlos.hogwarts.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.hogwarts.dtos.EstudianteDTO;
import com.carlos.hogwarts.service.EstudianteService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {
    private final EstudianteService estudianteService;

    @GetMapping("/test")
    public Map<String, String> probarEndpoint() {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "¡El controlador funciona correctamente!");
        respuesta.put("estado", "OK");
        return respuesta;
    }

    // Este es el método que devuelve la lista completa
    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> obtenerTodos() {
        List<EstudianteDTO> estudiantes = estudianteService.obtenerTodos();

        if (estudiantes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estudiantes);
    }
}
