package com.example.demo.service;

import com.example.demo.entity.Alumno;
import com.example.demo.mapper.AlumnoMapper;
import com.example.demo.repository.AlumnoRepository;
import com.example.demo.request.AlumnoRequest;
import com.example.demo.response.AlumnoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository repository;

    @Autowired
    private AlumnoMapper mapper;

    public Flux<AlumnoResponse> listar() {
        return repository.findAll().map(mapper::entityToResponse);
    }

    public Mono<AlumnoResponse> crear(AlumnoRequest request) {
        Mono<Alumno> ma = repository.findById(request.getId());
        return ma.hasElement()
                .map(a->!a)
                .filter(Boolean::booleanValue)
                .flatMap(b -> repository.save(Alumno.builder()
                                .id(request.getId())
                                .nombre(request.getNombre())
                                .apellido(request.getApellido())
                                .estado(request.getEstado())
                                .edad(request.getEdad())
                                .build())
                )
                .map(mapper::entityToResponse)
                .switchIfEmpty(Mono.error(new Exception("Id Exists")));

    }
}
