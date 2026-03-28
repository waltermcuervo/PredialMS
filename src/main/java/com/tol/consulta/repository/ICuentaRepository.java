package com.tol.consulta.repository;

import com.tol.consulta.entity.CuentaEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de cuentas de un contribuyente para acceder a la persistencia de la base de datos
 */
public interface ICuentaRepository extends JpaRepository<CuentaEntity, Long> {
}
