package com.example.demo.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

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
    @Pattern(regexp = "[A|I]")
    private String estado;

    @Min(0)
    @Max(120)
    private Integer edad;
}
