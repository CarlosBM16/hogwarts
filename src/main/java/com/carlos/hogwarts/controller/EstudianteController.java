package com.carlos.hogwarts.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.hogwarts.dtos.request.create.EstudianteCreateDTO;
import com.carlos.hogwarts.dtos.request.update.EstudianteUpdateDTO;
import com.carlos.hogwarts.dtos.response.EstudianteDTO;
import com.carlos.hogwarts.service.EstudianteService;

import jakarta.validation.Valid;
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

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> obtenerTodos() {
        List<EstudianteDTO> estudiantes = estudianteService.obtenerTodos();

        if (estudiantes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> obtenerEstudiantePorId(@PathVariable Long id) {
        EstudianteDTO dto = estudianteService.obtenerEstudiantePorId(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> crearEstudiante(@Valid @RequestBody EstudianteCreateDTO dto) {
        EstudianteDTO estudianteCreado = estudianteService.crearEstudiante(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteCreado);
    }

    @PutMapping("/{id}")
    // Parece ser que por motivos de seguridad, en versiones recientes de Spring,
    // hay que especificarle en @PathVariable el nombre de la variable
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(@PathVariable("id") Long id, @Valid @RequestBody EstudianteUpdateDTO dto) {
        EstudianteDTO estudianteActualizado = estudianteService.actualizarEstudiante(id, dto);
        return ResponseEntity.ok(estudianteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}
