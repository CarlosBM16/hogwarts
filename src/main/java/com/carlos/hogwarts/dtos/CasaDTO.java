package com.carlos.hogwarts.dtos;

import java.util.List;

import lombok.Data;

@Data
public class CasaDTO {
    private long id;
    private String nombre;
    private String fundador;
    private String fantasma;
    private ProfesorDTO jefe;
    private List<String> estudiantes;
}
