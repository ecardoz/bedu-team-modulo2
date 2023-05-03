package com.bedu.modulo2.reactive;

import com.bedu.modulo2.model.Curso;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CalcularPromedioCursoRx {
    public Mono<Double> calcularPromedio(Curso curso){

        return Flux.fromStream(curso.getCalificaciones().values().parallelStream())
                .reduce(0.0, (a, b) -> a + b)
                .map(sum -> sum / curso.getCalificaciones().size());

    }
}
