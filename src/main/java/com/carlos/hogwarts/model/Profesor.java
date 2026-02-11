package com.carlos.hogwarts.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

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
    @EqualsAndHashCode.Exclude  // <--- INDISPENSABLE
    @ToString.Exclude           // <--- EVITA ERRORES EN CONSOLA
    private Asignatura asignatura;

    @OneToOne(mappedBy = "jefe")
    @EqualsAndHashCode.Exclude  // <--- TAMBIÉN AQUÍ
    private Casa casa;
}
