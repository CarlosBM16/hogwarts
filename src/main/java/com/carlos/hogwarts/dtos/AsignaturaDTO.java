package com.carlos.hogwarts.dtos;

import lombok.Data;

@Data
public class AsignaturaDTO {
    private long id;
    private String nombre;
    private String aula;
    private boolean obligatoria;
    private String profesor;
}
