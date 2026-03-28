package com.tol.consulta.repository;

import com.tol.consulta.entity.ContribuyenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContribuyenteRepository extends JpaRepository<ContribuyenteEntity, Long> {
}
