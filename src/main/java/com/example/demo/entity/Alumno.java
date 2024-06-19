package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Alumno implements Persistable<Integer> {

    @Id
    @Column("id")
    private Integer id;

    @Column("nombre")
    private String nombre;

    @Column("apellido")
    private String apellido;

    @Column("estado")
    private String estado;

    @Column("edad")
    private Integer edad;

    // This new field tells us if the record is new
    @Transient
    @Builder.Default
    private boolean isNewEntry = true;

    // This method checks if the record is new
    public boolean isNew() {
        return isNewEntry;
    }
}
