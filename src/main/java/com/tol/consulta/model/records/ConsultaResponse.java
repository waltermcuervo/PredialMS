package com.tol.consulta.model.records;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Representa el resultado de la consulta de estado de una cuenta predial.
 */
public record ConsultaResponse(
        String nombre,
        BigDecimal valorDeuda,
        String estado,
        ConsultaRequest contribuyente,
        LocalDateTime fechaConsulta
) {
}
