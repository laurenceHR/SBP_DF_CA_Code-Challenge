package com.example.demo.controller;

import com.example.demo.mapper.AlumnoMapper;
import com.example.demo.request.AlumnoRequest;
import com.example.demo.response.AlumnoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoMapper mapper;

    @GetMapping
    public Flux<AlumnoResponse> list() {
        List<AlumnoResponse> alumnos = new ArrayList<>();
        return Flux.fromIterable(alumnos);
    }

    @PostMapping
    public Mono<AlumnoResponse> create(
            @Valid @RequestBody AlumnoRequest request) {
        return Mono.just(mapper.requestToResponse(request));
    }

}
