package com.bedu.modulo2.controller;

import com.bedu.modulo2.dto.estudiante.EstudianteCreadoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteToUpdateDto;
import com.bedu.modulo2.dto.materia.MateriaCreadaDto;
import com.bedu.modulo2.dto.materia.MateriaDto;
import com.bedu.modulo2.dto.materia.MateriaEliminadaDto;
import com.bedu.modulo2.dto.materia.MateriaToUpdateDto;
import com.bedu.modulo2.service.IMateriaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/materias")
@Data
public class MateriaController {
    private final IMateriaService materiaService;

    @Autowired
    public MateriaController(IMateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MateriaCreadaDto> crearMateria(
            @RequestBody @Valid MateriaDto materiaDto, UriComponentsBuilder uriComponentsBuilder
            ) {
        MateriaCreadaDto materiaCreadaDto = materiaService.crearMateria(materiaDto);
        URI location = uriComponentsBuilder.path("/materias/{id}")
                .buildAndExpand(materiaCreadaDto.id())
                .toUri();

        return ResponseEntity.created(location).body(materiaCreadaDto);
    }

    @GetMapping
    public ResponseEntity<Page<MateriaCreadaDto>> obtenerMaterias(Pageable pageable) {
        return ResponseEntity.status(200).body(materiaService.obtenerMaterias(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaCreadaDto> obtenerMateria(@PathVariable Long id) {
        return ResponseEntity.status(200).body(materiaService.obtenerMateria(id));
    }

    @DeleteMapping("/{id}")
    public void eliminarMateria(@PathVariable Long id) {
        materiaService.eliminarMateria(id);
    }

    /** Materia solo cuenta con un campo a editar
     * nombreMateria.
     * */
    @PutMapping
    @Transactional
    public ResponseEntity<MateriaCreadaDto> actualizarMateria(
            @RequestBody @Valid MateriaToUpdateDto materiaToUpdateDto) {
        return ResponseEntity
                .status(200)
                .body(materiaService.actualizarMateria(materiaToUpdateDto));
    }
}
