package com.carlos.hogwarts.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@Entity
@Table(name = "casa")

public class Casa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_casa;

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
