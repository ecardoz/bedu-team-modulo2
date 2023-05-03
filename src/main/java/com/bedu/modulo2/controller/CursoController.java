//package com.bedu.modulo2.controller;
//
//import com.bedu.modulo2.dto.CalificacionDTO;
//import com.bedu.modulo2.exceptions.ErrorAlOperarRegistroException;
//import com.bedu.modulo2.exceptions.RegistroExistenteException;
//import com.bedu.modulo2.exceptions.RegistroInvalidoException;
//import com.bedu.modulo2.model.Curso;
//import com.bedu.modulo2.service.CursoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/curso")
//public class CursoController {
//    private final CursoService cursoService;
//    private final EstudianteService estudianteService;
//
//    @Autowired
//    public CursoController(CursoService cursoService, EstudianteService estudianteService) {
//        this.cursoService = cursoService;
//        this.estudianteService = estudianteService;
//    }
//
//    /*Peticion HTTP al crear un Curso*/
//    @PostMapping
//    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
//        try {
//            Curso cursoDB = cursoService.crearCurso(curso);
//            return ResponseEntity.ok(cursoDB);
//        } catch (RegistroInvalidoException | RegistroExistenteException e) {
//            System.out.println(e.getMessage());
//            return ResponseEntity.badRequest().body(null);
//        } catch (ErrorAlOperarRegistroException e) {
//            System.out.println(e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//
//    /*Peticion HTTP para obtener un curso mediante su id*/
//    @GetMapping
//    @RequestMapping("/{id}")
//    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable Long id) {
//        try {
//            Curso cursoDB = cursoService.obtenerCursoPorId(id);
//            return ResponseEntity.ok(cursoDB);
//        } catch (RegistroInvalidoException | RegistroExistenteException e) {
//            System.out.println(e.getMessage());
//            return ResponseEntity.badRequest().body(null);
//        } catch (ErrorAlOperarRegistroException e) {
//            System.out.println(e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//
//    /*Peticion HTTP para solicitar todos los cursos*/
//    @GetMapping
//    public ResponseEntity<List<Curso>> obtenerTodosLosCursos() {
//        try {
//            List<Curso> cursosDB = cursoService.obtenerCursos();
//            return ResponseEntity.ok(cursosDB);
//        } catch (ErrorAlOperarRegistroException e) {
//            System.out.println(e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//
//    /*Peticion HTTP para eliminar un curso por su ID*/
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> eliminarCursoPorId(@PathVariable Long id) {
//        try {
//            cursoService.eliminarCursoPorId(id);
//            return new ResponseEntity<>(
//              String.format("El curso con id %d ha sido eliminado con exito", id),
//              HttpStatus.OK
//            );
//        } catch (RegistroInvalidoException | RegistroExistenteException e) {
//            System.out.println(e.getMessage());
//            return ResponseEntity.badRequest().body(null);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//
//    /*Peticion HTTP para actualizar un curso*/
//    @PutMapping
//    public ResponseEntity<Curso> actualizarCurso(@RequestBody Curso curso) {
//        try {
//            Curso cursoDB = cursoService.actualizarCurso(curso);
//            return ResponseEntity.ok(cursoDB);
//        } catch (RegistroInvalidoException | RegistroExistenteException e) {
//            System.out.println(e.getMessage());
//            return ResponseEntity.badRequest().body(null);
//        } catch (ErrorAlOperarRegistroException e) {
//            System.out.println(e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//
//    /*Peticion para agregar un Estudiante y su Calificacion a un Curso*/
//    @PutMapping
//    @RequestMapping("/agregarCalificacion")
//    public ResponseEntity<Curso> agregarCalificacion(@RequestBody CalificacionDTO calificacionDTO) {
//        Curso curso = calificacionDTO.getCurso();
//        Estudiante estudiante = calificacionDTO.getEstudiante();
//        Integer calificacion = calificacionDTO.getCalificacion();
//
//        try {
//            System.out.println(curso);
//            Curso cursoDB = cursoService.agregarCalificacion(curso, estudiante, calificacion);
//            return ResponseEntity.ok(cursoDB);
//        } catch (RegistroInvalidoException | RegistroExistenteException e) {
//            System.out.println(e.getMessage());
//            return ResponseEntity.badRequest().body(null);
//        } catch (ErrorAlOperarRegistroException e) {
//            System.out.println(e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//
//}
