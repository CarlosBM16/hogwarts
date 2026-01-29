package com.carlos.hogwarts.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor 
@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_profesor;
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fecha_inicio")
    private Date fecha_inicio;

    @OneToOne
    @JoinColumn(name = "id_asignatura")
    @JsonManagedReference
    private Asignatura asignatura;

    @OneToOne(mappedBy = "jefe")
    @JsonBackReference
    private Casa casa;
}
