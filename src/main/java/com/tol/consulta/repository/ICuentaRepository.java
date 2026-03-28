package com.tol.consulta.repository;

import com.tol.consulta.entity.CuentaEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICuentaRepository extends JpaRepository<CuentaEntity, Long> {
}
