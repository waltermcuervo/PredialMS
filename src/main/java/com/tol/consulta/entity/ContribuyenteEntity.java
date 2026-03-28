package com.tol.consulta.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

/**
 * Entidad que representa a un contribuyente en la base de datos.
 */
@Data
@Entity
@Table(schema = "TOL", name = "CONTRIBUYENTE")
public class ContribuyenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TIPO_DOCUMENTO")
    private String tipDoc;

    @Column(name = "NUM_DOCUMENTO")
    private String numDocumento;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "FECHA_REGISTRO")
    private LocalDate fechaRegistro;

}
