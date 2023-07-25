package com.bedu.modulo2.repository;

import com.bedu.modulo2.model.Curso;
import com.bedu.modulo2.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    boolean existsByCicloAndMateria(String ciclo, Materia materia);

    boolean existsById(Long id);

    Curso getById(Long id);

}
