package com.tol.consulta.service.implementation;

import com.tol.consulta.model.records.ConsultaRequest;
import com.tol.consulta.model.records.ConsultaResponse;

public interface ICuentaPredialService {

    ConsultaResponse consultarEstadoPredial(ConsultaRequest resp);
}
