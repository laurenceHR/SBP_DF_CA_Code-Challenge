package com.example.demo.mapper;

import com.example.demo.entity.Alumno;
import com.example.demo.request.AlumnoRequest;
import com.example.demo.response.AlumnoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {

    AlumnoResponse requestToResponse(AlumnoRequest request);

    Alumno requestToEntity(AlumnoRequest request);

    AlumnoResponse entityToResponse(Alumno alumno);
}
