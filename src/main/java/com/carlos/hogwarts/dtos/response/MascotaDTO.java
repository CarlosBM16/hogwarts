package com.carlos.hogwarts.dtos.response;

import lombok.Data;

@Data
public class MascotaDTO {
    private long id;
    private String nombre;
    private String especie;
    private String estudiante;
}
