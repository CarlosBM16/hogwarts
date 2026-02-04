package com.carlos.hogwarts.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carlos.hogwarts.dtos.response.CasaDTO;
import com.carlos.hogwarts.mapper.CasaMapper;
import com.carlos.hogwarts.repository.CasaRepository;
import com.carlos.hogwarts.service.CasaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CasaServiceImpl implements CasaService {
    private final CasaRepository casaRepository;
    private final CasaMapper casaMapper;

    @Override
    public List<CasaDTO> obtenerTodas() {
        return casaRepository.findAll()
            .stream()
            .map(casaMapper::toDto)
            .toList();
    }
}
