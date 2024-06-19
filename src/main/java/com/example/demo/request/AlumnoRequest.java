package com.example.demo.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class AlumnoRequest {

    @Min(1)
    private Integer id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    private String estado;

    @Min(0)
    @Max(120)
    private Integer edad;
}
