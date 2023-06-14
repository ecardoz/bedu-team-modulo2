package com.bedu.modulo2.controller;

import com.bedu.modulo2.dto.estudiante.EstudianteCreadoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteDto;
import com.bedu.modulo2.dto.estudiante.EstudianteEliminadoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteToUpdateDto;
import com.bedu.modulo2.service.EstudianteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/estudiantes")
@Data
public class EstudianteController {

    private final EstudianteService estudianteService;

    @PostMapping
    @Transactional
    public ResponseEntity<EstudianteCreadoDto> crearEstudiante(
              @RequestBody @Valid EstudianteDto estudianteDto,
              UriComponentsBuilder uriComponentsBuilder)
    {

        EstudianteCreadoDto estudianteCreadoDto = estudianteService.crearEstudiante(estudianteDto);
        URI location = uriComponentsBuilder.path("/estudiantes/{id}").buildAndExpand(estudianteCreadoDto.id()).toUri();
        return ResponseEntity.created(location).body(estudianteCreadoDto);
    }

    @GetMapping
    public ResponseEntity<Page<EstudianteCreadoDto>> obtenerEstudiantes(Pageable pageable) {
        return ResponseEntity.status(200).body(estudianteService.obtenerEstudiantes(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteCreadoDto> obtenerEstudiante(@PathVariable Long id) {
        return ResponseEntity.status(200).body(estudianteService.obtenerEstudiante(id));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<EstudianteEliminadoDto> eliminarEstudiante(@PathVariable Long id) {
        return ResponseEntity.status(200).body(estudianteService.eliminarEstudiante(id));
    }

    /** Solo se pueden actualizar los campos nombreCompleto, y los
     * campos de la dirección. Email y CURP no se pueden actualizar.
     * */
    @PutMapping
    @Transactional
    public ResponseEntity<EstudianteCreadoDto> actualizarEstudiante(@RequestBody @Valid EstudianteToUpdateDto estudianteToUpdateDto) {
        return ResponseEntity.status(200).body(estudianteService.actualizarEstudiante(estudianteToUpdateDto));
    }
}
