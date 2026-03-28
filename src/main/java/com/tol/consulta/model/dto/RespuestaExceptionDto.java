package com.tol.consulta.model.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO de la respuesta de excepcion
 */
@Builder
@Data
public class RespuestaExceptionDto {

    private String mensaje;

    private Boolean esError;

    private LocalDateTime hora;

    private String codigo;

    private String uri;
}
