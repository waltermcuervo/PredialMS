package com.tol.consulta.entity;

import com.tol.consulta.model.enums.EstadoEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(schema = "TOL", name = "CUENTA")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COD_CATASTRAL")
    private String codCatastro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTRIBUYENTE_ID")
    private ContribuyenteEntity contribuyente;

    @Column(name = "DEUDA_VALOR")
    private BigDecimal deuda;

    @Column(name = "ESTADO")
    private EstadoEnum estado;

    @Column(name = "FECHA_VENCIMIENTO")
    private LocalDate fecha_vencimiento;
}
