package com.carlos.hogwarts.mapper;

import com.carlos.hogwarts.dtos.response.CasaDTO;
import com.carlos.hogwarts.model.Casa;

public class CasaMapper {
    public CasaDTO toDto(Casa casa) {
        CasaDTO dto = new CasaDTO();

        dto.setId(casa.getId_casa());
        dto.setNombre(casa.getNombre());
        dto.setFundador(casa.getFundador());
        dto.setFantasma(casa.getFantasma());
        dto.setJefe(new ProfesorMapper().toDto(casa.getJefe()));

        return dto;
    }
}
