package com.repository;

import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@Testcontainers
@TestPropertySource(properties = {"spring.jpa.hibernate.ddl-auto=create-drop"}) // Hibernate genera las tablas en el contenedor
public class EstudianteRepositoryContainers {
    
}
