package com.tol.consulta.service;

import com.tol.consulta.exception.ElementNotFoundException;
import com.tol.consulta.model.enums.EstadoEnum;
import com.tol.consulta.model.records.ConsultaRequest;
import com.tol.consulta.model.records.ConsultaResponse;
import com.tol.consulta.repository.ICuentaRepository;
import com.tol.consulta.service.implementation.ICuentaPredialService;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Servicio encargado de gestionar la lógica de negocio de las cuentas prediales de un contribuyente.
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CuentaPredialService implements ICuentaPredialService {

    private final ICuentaRepository cuentaRepository;


    private final EntityManager entityManager;

    @Override
    public ConsultaResponse consultarEstadoPredial(ConsultaRequest resp) {
        log.info("inicio consulta predial: {} por parte del usuario {} con tipo de documento {}", resp.codCatastral(), resp.numDocumento(), resp.tipoDocumento());

        StoredProcedureQuery query = null;
        try {
            //return cuentaRepository.obtenerEstadoCuenta(resp.codCatastral(), resp.numDocumento(), resp.tipoDocumento());
            query = entityManager.createStoredProcedureQuery("TOL.SP_CONSULTAR_ESTADO_CUENTA");

            // Parámetros IN
            query.registerStoredProcedureParameter("P_COD_CATASTRAL", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_NUM_DOCUMENTO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_TIPO_DOC", String.class, ParameterMode.IN);

            // Parámetros OUT
            query.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter("P_VALOR_DEUDA", BigDecimal.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter("P_ESTADO", String.class, ParameterMode.OUT);

            query.setParameter("P_COD_CATASTRAL", resp.codCatastral());
            query.setParameter("P_NUM_DOCUMENTO", resp.numDocumento());
            query.setParameter("P_TIPO_DOC", resp.tipoDocumento().toUpperCase());

            query.execute();

        } catch (PersistenceException ex) {
            log.error("Error en la consulta: {}", ex.getMessage(), ex);
            throw new ElementNotFoundException(ex.getMessage());
        }

        log.info("Consulta realizada exitosamete para el catastro: {} por parte del usuario: {}", resp.codCatastral(), resp.numDocumento());

        return new ConsultaResponse(
                (String) query.getOutputParameterValue("P_NOMBRE"),
                (BigDecimal) query.getOutputParameterValue("P_VALOR_DEUDA"),
                EstadoEnum.valueOf((String) query.getOutputParameterValue("P_ESTADO")).getNombre(),
                resp,
                LocalDateTime.now()
        );
    }
}
