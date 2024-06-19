package com.example.demo.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class AlumnoResponse {

    public Integer id;

    private String nombre;

    private String apellido;

    private String estado;

    private Integer edad;
}
