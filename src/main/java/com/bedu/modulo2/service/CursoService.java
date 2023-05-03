//package com.bedu.modulo2.service;
//
//import com.bedu.modulo2.exceptions.ErrorAlOperarRegistroException;
//import com.bedu.modulo2.exceptions.RegistroExistenteException;
//import com.bedu.modulo2.exceptions.RegistroInvalidoException;
//import com.bedu.modulo2.model.Curso;
//import com.bedu.modulo2.repository.CursoRepository;
//import com.bedu.modulo2.utils.Configuraciones;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CursoService {
//    private final CursoRepository cursoRepository;
//
//    @Autowired
//    public CursoService(CursoRepository cursoRepository) {
//        this.cursoRepository = cursoRepository;
//    }
//
//    /*Guarda un nuevo curso en la BD*/
//    public Curso crearCurso(Curso curso) {
//
//        // Realizar validaciones en el objeto curso
//        if (curso.getCiclo() == null || curso.getCiclo().isEmpty() || curso.getMateria() == null || curso.getMateria().getId() == null || curso.getMateria().getNombre().isEmpty()) {
//            throw new RegistroInvalidoException("El ciclo no puede ser nulo o vacío");
//        }
//
//        // Verificar si ya existe un registro con el mismo nombre en la base de datos (ciclo y materia)
//        if (cursoRepository.existsByCicloAndMateria(curso.getCiclo(), curso.getMateria())) {
//            throw new RegistroExistenteException("Ya existe un curso con el mismo ciclo y materia.");
//        }
//
//        // Guardar el nuevo registro en la base de datos
//        try {
//            return cursoRepository.save(curso);
//        } catch (Exception e) {
//            throw new ErrorAlOperarRegistroException("No se pudo guardar el registro en la base de datos.", e);
//        }
//    }
//
//    /*Busca un curso por su ID en la BD y lo retorna*/
//    public Curso obtenerCursoPorId(Long id) {
//        // Realizar validaciones en el objeto curso
//        if (id == null || id <= 0) {
//            throw new RegistroInvalidoException("ID del curso inválido. Ingrese un ID válido.");
//        }
//
//        // Verificar si existe el curso en la base de datos
//        if (!cursoRepository.existsById(id)) {
//            throw new RegistroExistenteException("No existe un curso con ese ID.");
//        }
//
//        // Obtenemos el curso de la base de datos
//        try {
//            return cursoRepository.findById(id).orElse(null);
//        } catch (Exception e) {
//            throw new ErrorAlOperarRegistroException("No se pudo obtener el registro de la base de datos.", e);
//        }
//    }
//
//    /*Obtiene todos los cursos que están en la BD*/
//    public List<Curso> obtenerCursos() {
//        // Obtenemos todos los cursos de la base de datos
//        try {
//            return cursoRepository.findAll();
//        } catch (Exception e) {
//            throw new ErrorAlOperarRegistroException("No se pudieron obtener los registros de Cursos de la BD.", e);
//        }
//    }
//
//    /*Elimina un curso por su ID en la BD*/
//    public void eliminarCursoPorId(Long id) {
//        // Realizar validaciones en el objeto curso
//        if (id == null || id <= 0) {
//            throw new RegistroInvalidoException("ID del curso inválido. Ingrese un ID válido.");
//        }
//
//        // Verificar si existe el curso en la base de datos
//        if (!cursoRepository.existsById(id)) {
//            throw new RegistroExistenteException("No existe un curso con ese ID.");
//        }
//
//        // Eliminamos el curso de la base de datos
//        try {
//            cursoRepository.deleteById(id);
//        } catch (Exception e) {
//            throw new ErrorAlOperarRegistroException("No se pudo eliminar el registro de la base de datos.", e);
//        }
//    }
//
//    /*Actualiza un curso por su ID en la BD:
//     * - El Ciclo
//     * - Materia: Id, Nombre*/
//    public Curso actualizarCurso(Curso curso) {
//        Long id = curso.getId();
//
//        // Actualizamos el curso en la base de datos
//        try {
//            Curso cursoBD = obtenerCursoPorId(id);
//
//            //Existe un Ciclo nuevo
//            if (curso.getCiclo() != null && !curso.getCiclo().isEmpty())
//                cursoBD.setCiclo(curso.getCiclo());
//
//            //Existe una Materia nueva
//            if (curso.getMateria() != null &&
//              curso.getMateria().getId() != null &&
//              curso.getMateria().getId() > 0 &&
//              curso.getMateria().getNombre() != null &&
//              !curso.getMateria().getNombre().isEmpty()
//            )
//                cursoBD.setMateria(curso.getMateria());
//
//            //Existe Map de Calificaciones nuevas
//            if (curso.getCalificaciones() != null && !curso.getCalificaciones().isEmpty())
//                cursoBD.setCalificaciones(curso.getCalificaciones());
//
//            return cursoRepository.save(cursoBD);
//        } catch (Exception e) {
//            throw new ErrorAlOperarRegistroException("No se pudo actualizar el Curso en la base de datos.", e);
//        }
//    }
//
//    /*Agregar calificacion a estudiante de un Curso*/
//    public Curso agregarCalificacion(Curso curso, Estudiante estudiante, Integer calificacion) {
//        // Realizar validaciones en el objeto curso
//        if (curso.getId() == null || curso.getId() <= 0) {
//            throw new RegistroInvalidoException("ID del curso inválido. Ingrese un ID válido.");
//        }
//
//        // Verificar si existe el curso en la base de datos
//        if (!cursoRepository.existsById(curso.getId())) {
//            throw new RegistroExistenteException("No existe un curso con ese ID.");
//        }
//
//        // Obtenemos el curso de la base de datos
//        try {
//            Curso cursoBD = obtenerCursoPorId(curso.getId());
//
//            // Realizar validaciones en el objeto estudiante
//            if (estudiante.getId() == null || estudiante.getId() <= 0) {
//                throw new RegistroInvalidoException("ID del estudiante inválido. Ingrese un ID válido.");
//            }
//
//            // Realizar validaciones en el objeto calificacion
//            if (calificacion == null || calificacion < 0 || calificacion > Configuraciones.CALIFICACION_MAXIMA) {
//                throw new RegistroInvalidoException("Calificación inválida. Ingrese una calificación válida.");
//            }
//
//            // Agregamos la calificación al estudiante en el curso
//            cursoBD.agregarCalificacion(estudiante, calificacion);
//
//            return cursoRepository.save(cursoBD);
//        } catch (Exception e) {
//            throw new ErrorAlOperarRegistroException("No se pudo agregar la calificación al estudiante en el curso.", e);
//        }
//    }
//
//}