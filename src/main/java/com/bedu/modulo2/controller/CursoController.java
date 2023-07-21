package com.bedu.modulo2.controller;

import com.bedu.modulo2.dto.curso.CursoCreadoDto;
import com.bedu.modulo2.dto.curso.CursoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteCreadoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteDto;
import com.bedu.modulo2.dto.materia.MateriaCreadaDto;
import com.bedu.modulo2.dto.materia.MateriaDto;
import com.bedu.modulo2.exceptions.estudiante.EstudianteNotFoundException;
import com.bedu.modulo2.service.ICursoService;
import com.bedu.modulo2.service.IEstudianteService;
import com.bedu.modulo2.service.IMateriaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
@Data
public class CursoController {

    private final ICursoService cursoService;

    @PostMapping
    @Transactional
    public ResponseEntity<CursoCreadoDto> crearCurso(
            @RequestBody @Valid CursoDto cursoDto,
            UriComponentsBuilder uriComponentsBuilder) {
        CursoCreadoDto cursoCreadoDto = cursoService.crearCurso(cursoDto);
        URI location = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(cursoCreadoDto.id()).toUri();
        return ResponseEntity.created(location).body(cursoCreadoDto);
    }

    @GetMapping
    public ResponseEntity<Page<CursoCreadoDto>> obtenerCursos(Pageable pageable) {
        if(cursoService.obtenerCursos(pageable).getTotalElements() > 0)
            return ResponseEntity.status(200).body(cursoService.obtenerCursos(pageable));
        else
            throw new EstudianteNotFoundException("No se encontraron CURSOS");
    }


    @GetMapping("/{id}")
    public ResponseEntity<Page<CursoCreadoDto>> obtenerEstudiantes(@PathVariable Long id,
                                                                        Pageable pageable) {
        if(cursoService.obtenerCursosEstudiante(id, pageable).getTotalElements() > 0)
            return ResponseEntity.status(200).body(cursoService.obtenerCursosEstudiante(id,pageable));
        else
            throw new EstudianteNotFoundException("No se encontraron CURSOS por Estudiante");
    }

}