package com.carlos.hogwarts.service;

import java.util.List;

import com.carlos.hogwarts.dtos.response.CasaDTO;

public interface CasaService {
    List<CasaDTO> obtenerTodas();
}
