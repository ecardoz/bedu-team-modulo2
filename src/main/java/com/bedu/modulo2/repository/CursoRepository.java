package com.bedu.modulo2.repository;

import com.bedu.modulo2.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
