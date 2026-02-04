package com.carlos.hogwarts.mapper;

import org.springframework.stereotype.Component;

import com.carlos.hogwarts.dtos.response.CasaDTO;
import com.carlos.hogwarts.model.Casa;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Data
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
