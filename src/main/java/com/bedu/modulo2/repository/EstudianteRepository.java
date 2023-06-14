package com.bedu.modulo2.repository;

import com.bedu.modulo2.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
