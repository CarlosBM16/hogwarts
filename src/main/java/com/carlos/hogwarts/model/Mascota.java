package com.carlos.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor 
@Entity
@Table(name = "mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mascota;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "especie")
    private String especie;

    @OneToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    @EqualsAndHashCode.Exclude  // <--- INDISPENSABLE
    @ToString.Exclude           // <--- EVITA ERRORES EN CONSOLA
    private Estudiante estudiante;
}
