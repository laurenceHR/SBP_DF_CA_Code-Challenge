package com.example.demo;

import com.example.demo.catalog.AlumnoEstadoCatalog;
import com.example.demo.entity.Alumno;
import com.example.demo.mapper.AlumnoMapper;
import com.example.demo.repository.AlumnoRepository;
import com.example.demo.response.AlumnoResponse;
import com.example.demo.service.AlumnoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class DemoApplicationTests {

	@InjectMocks
	private AlumnoServiceImpl alumnoService;

	@Mock
	private AlumnoRepository repository;

	@Spy
	private AlumnoMapper mapper = Mappers.getMapper(AlumnoMapper.class);

	@Mock
	Logger log;

	@BeforeEach
	public void setup() {
		Mockito.when(repository.findByEstado(Mockito.anyString()))
				.thenReturn(
						Flux.just(Alumno.builder()
								.estado("A")
								.build()));
	}

	@Test
	void contextLoads() {
		Flux<AlumnoResponse> alumnos = this.alumnoService.listarActivos();
		log.info("alumnos: {}", alumnos);
		StepVerifier.create(alumnos)
				.expectNextMatches(a ->
						AlumnoEstadoCatalog.ACTIVO.getEstado().equalsIgnoreCase(a.getEstado()))
				.verifyComplete();
	}

}
