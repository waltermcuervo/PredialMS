package com.tol.consulta.model.dto;

import com.tol.consulta.model.records.ConsultaRequest;
import com.tol.consulta.model.records.ConsultaResponse;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultaResponseDto {

        private ConsultaResponse cuenta;
        private ConsultaRequest contribuyente;
        private LocalDateTime fechaConsulta;
}
