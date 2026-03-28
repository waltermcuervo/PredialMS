package com.tol.consulta.repository;

import com.tol.consulta.entity.ContribuyenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de contribuyentes para acceder a la persistencia de la base de datos
 */
public interface IContribuyenteRepository extends JpaRepository<ContribuyenteEntity, Long> {
}
