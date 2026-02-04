package com.carlos.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.hogwarts.model.Casa;

public interface CasaRepository extends JpaRepository<Casa, Long> {
    
}
