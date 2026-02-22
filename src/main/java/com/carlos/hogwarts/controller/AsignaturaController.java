package com.carlos.hogwarts.controller;

import org.springframework.web.bind.annotation.RestController;

import com.carlos.hogwarts.service.AsignaturaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/asignaturas")
@RequiredArgsConstructor
public class AsignaturaController {
    private final AsignaturaService asignaturaService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        asignaturaService.eliminarAsignatura(id);
        return ResponseEntity.noContent().build();
    }

}
