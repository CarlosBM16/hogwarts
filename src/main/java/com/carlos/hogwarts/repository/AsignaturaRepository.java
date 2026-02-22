package com.carlos.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.hogwarts.model.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
    
}
