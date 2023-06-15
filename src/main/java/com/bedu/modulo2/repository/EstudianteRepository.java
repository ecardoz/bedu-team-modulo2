package com.bedu.modulo2.repository;

import com.bedu.modulo2.model.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Page<Estudiante> findAllByActivoTrue(Pageable pageable);

    Estudiante getByIdAndActivoTrue(Long id);

    boolean existsByEmail(String email);

    boolean existsByCurp(String curp);
}
