package com.example.demo.catalog;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AlumnoEstadoCatalog {

    ACTIVO("A"),
    INACTIVO("I");

    String estado;
}
