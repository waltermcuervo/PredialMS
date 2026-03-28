package com.tol.consulta.service.implementation;

import com.tol.consulta.model.records.ConsultaRequest;
import com.tol.consulta.model.records.ConsultaResponse;

/**
 * Servicio encargado de gestionar la lógica de negocio de las cuentas prediales de un contribuyente.
 */
public interface ICuentaPredialService {

    /**
     * Procesa la consulta de estado de un predio.
     *
     * @param resp Solicitud con los criterios de búsqueda.
     * @return Resultado con el estado de la deuda y los datos correspondientes.
     */
    ConsultaResponse consultarEstadoPredial(ConsultaRequest resp);
}
