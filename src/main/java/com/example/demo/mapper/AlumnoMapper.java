package com.example.demo.mapper;

import com.example.demo.request.AlumnoRequest;
import com.example.demo.response.AlumnoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {

    AlumnoResponse requestToResponse(AlumnoRequest request);
}
