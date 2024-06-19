package com.example.demo.repository;

import com.example.demo.entity.Alumno;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnoRepository extends ReactiveCrudRepository<Alumno, Integer> {

    Mono<Alumno> findById(Integer id);

    Flux<Alumno> findByEstado(String estado);

}