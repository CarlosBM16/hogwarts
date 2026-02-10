package com.carlos.hogwarts.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_casa")
    private Casa casa;

    @Column(name = "anyo_curso")
    private int anyo_curso;

    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;

    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL, optional = true)
    @JsonManagedReference
    private Mascota mascota;

    @ManyToMany(mappedBy = "estudiantes")
    @JsonIgnore
    private List<Asignatura> asignaturas;
}
