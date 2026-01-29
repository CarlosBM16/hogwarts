package com.carlos.hogwarts.mapper;

import org.springframework.stereotype.Component;

import com.carlos.hogwarts.dtos.MascotaDTO;
import com.carlos.hogwarts.model.Mascota;

import lombok.Data;

@Component
@Data
public class MascotaMapper {
    public MascotaDTO toDto(Mascota mascota) {
        if (mascota == null) return null;
        
        MascotaDTO dto = new MascotaDTO();
        
        dto.setId(mascota.getId_mascota());
        dto.setNombre(mascota.getNombre());
        dto.setEspecie(mascota.getEspecie());
        dto.setEstudiante(mascota.getEstudiante().getNombre());

        return dto;
    }
}
