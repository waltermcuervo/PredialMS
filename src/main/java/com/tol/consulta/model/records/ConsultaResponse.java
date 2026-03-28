package com.tol.consulta.model.records;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ConsultaResponse(
        String nombre,
        BigDecimal valorDeuda,
        String estado,
        ConsultaRequest contribuyente,
        LocalDateTime fechaConsulta
) {
}
