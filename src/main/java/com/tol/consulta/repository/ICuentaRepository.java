package com.tol.consulta.repository;

import com.tol.consulta.entity.CuentaEntity;

import com.tol.consulta.model.records.ConsultaResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

/**
 * Repositorio de cuentas de un contribuyente para acceder a la persistencia de la base de datos
 */
public interface ICuentaRepository extends JpaRepository<CuentaEntity, Long> {

    @Procedure(procedureName = "TOL.SP_CONSULTAR_ESTADO_CUENTA")
    ConsultaResponse obtenerEstadoCuenta(String codCatastro, String numDocumento, String tipoDocumento);
}
