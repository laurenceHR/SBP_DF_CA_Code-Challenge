package com.example.demo.service;

import com.example.demo.entity.Alumno;
import com.example.demo.request.AlumnoRequest;
import com.example.demo.response.AlumnoResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnoService {

    public Flux<AlumnoResponse> listar();

    Mono<AlumnoResponse> crear(AlumnoRequest request);

    Flux<AlumnoResponse> listarActivos();
}
