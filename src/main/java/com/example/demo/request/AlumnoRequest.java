package com.example.demo.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class AlumnoRequest {

    @Min(1)
    private Integer id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @Length(min=1, max=1)
    private String estado;

    @Min(0)
    @Max(120)
    private Integer edad;
}
