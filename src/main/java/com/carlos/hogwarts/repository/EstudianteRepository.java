package com.carlos.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.hogwarts.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
    
}
