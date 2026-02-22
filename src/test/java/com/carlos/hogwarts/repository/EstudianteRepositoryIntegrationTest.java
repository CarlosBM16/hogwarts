package com.carlos.hogwarts.repository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.carlos.hogwarts.model.Estudiante;
import com.carlos.hogwarts.model.Mascota;

import jakarta.persistence.EntityManager;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class EstudianteRepositoryIntegrationTest {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void eliminarEstudiante_debeEliminarMascotaEnCascada() {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Harry");
        estudiante.setApellido("Potter");
        estudiante.setAnyo_curso(1);
        estudiante.setFecha_nacimiento(LocalDate.of(1980, 7, 31));

        Mascota mascota = new Mascota();
        mascota.setNombre("Hedwig");
        mascota.setEspecie("Buho");

        mascota.setEstudiante(estudiante);
        estudiante.setMascota(mascota);

        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);
        int idMascota = estudianteGuardado.getMascota().getId_mascota();
        Long idEstudiante = estudianteGuardado.getId();

        estudianteRepository.delete(estudianteGuardado);

        estudianteRepository.flush();
        entityManager.clear();

        assertFalse(estudianteRepository.findById(idEstudiante).isPresent(), 
            "El estudiante debería haber sido eliminado");

        Mascota mascotaEnBD = entityManager.find(Mascota.class, idMascota);
        assertNull(mascotaEnBD, "La mascota debería haber sido borrada por la cascada (CascadeType.ALL)");
    }
}
