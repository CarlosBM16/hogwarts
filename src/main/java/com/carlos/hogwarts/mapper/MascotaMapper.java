package com.carlos.hogwarts.mapper;

import com.carlos.hogwarts.dtos.request.create.MascotaCreateDTO;
import com.carlos.hogwarts.dtos.response.MascotaDTO;
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

    public Mascota toEntity(MascotaCreateDTO dto) {
        Mascota mascota = new Mascota();

        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());

        return mascota;
    }
}
