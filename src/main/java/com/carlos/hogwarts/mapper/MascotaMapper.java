package com.carlos.hogwarts.mapper;

import com.carlos.hogwarts.dtos.MascotaDTO;
import com.carlos.hogwarts.model.Mascota;

public class MascotaMapper {
    public MascotaDTO toDto(Mascota mascota) {
        MascotaDTO dto = new MascotaDTO();
        
        dto.setId(mascota.getId_mascota());
        dto.setNombre(mascota.getNombre());
        dto.setEspecie(mascota.getEspecie());
        dto.setEstudiante(mascota.getEstudiante().getNombre());

        return dto;
    }
}
