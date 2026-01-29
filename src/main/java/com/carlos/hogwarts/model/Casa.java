package com.carlos.hogwarts.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@NoArgsConstructor 
@Entity
@Table(name = "casa")

public class Casa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_casa;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fundador")
    private String fundador;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "id_jefe")
    private Profesor jefe;

    @Column(name = "fantasma")
    private String fantasma;

    @OneToMany(mappedBy = "casa")
    @JsonManagedReference

    
    private List<Estudiante> estudiantes;
}
