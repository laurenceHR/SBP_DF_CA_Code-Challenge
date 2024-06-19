package com.example.demo.controller;

import com.example.demo.mapper.AlumnoMapper;
import com.example.demo.request.AlumnoRequest;
import com.example.demo.response.AlumnoResponse;
import com.example.demo.service.AlumnoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.EntityResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoMapper mapper;

    @Autowired
    private AlumnoService service;

    @GetMapping
    public Flux<AlumnoResponse> list(
            @RequestParam(name = "activo", required = false) Boolean activo) {
        log.debug("activo: {}", activo);
        return Optional.ofNullable(activo)
                .filter(Boolean::booleanValue)
                .map(a -> service.listarActivos())
                .orElseGet(() -> service.listar());
    }

    @PostMapping
    public Mono<ResponseEntity<AlumnoResponse>> create(
            @Valid @RequestBody AlumnoRequest request) {
        return service.crear(request)
                .map(ResponseEntity::ok)
                .onErrorReturn(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

}
